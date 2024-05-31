package com.ebook.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ebook.common.To.UserTo;
import com.ebook.common.common.MessageContent;
import com.ebook.common.common.R;
import com.ebook.common.common.RedisCommon;
import com.ebook.order.entity.Order;
import com.ebook.order.dao.OrderDao;
import com.ebook.order.entity.vo.CartVo;
import com.ebook.common.vo.OrderItemVo;
import com.ebook.order.feign.BookFeignService;
import com.ebook.order.feign.ThirdpartyFeignService;
import com.ebook.order.service.IOrderItemService;
import com.ebook.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 * service impl class
 * </p>
 *
 * @author yuhan
 * @since 2022-10-05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements IOrderService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private BookFeignService bookFeignService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private APIContext apiContext;

    @Autowired
    private IOrderItemService orderItemService;

    @Autowired
    private ThreadPoolExecutor executor;

    @Autowired
    private ThirdpartyFeignService thirdpartyFeignService;

    @Override
    public CartVo getCart(String username) {
        String key = RedisCommon.USER_CART_PREFIX + username;
        Set<String> set = stringRedisTemplate.opsForSet().members(key);
        if (set == null || set.isEmpty()) {
            return new CartVo();
        }
        List<Long> bookIdList = new ArrayList<>();
        for (String bookId : set) {
            bookIdList.add(Long.parseLong(bookId));
        }
        R res = bookFeignService.wrapOrderItemVo(bookIdList);
        List<OrderItemVo> orderItemVoList = JSON.parseObject(JSON.toJSONString(res.getData().get("OrderItemVoList"))
                , new TypeReference<List<OrderItemVo>>() {
                });
        return new CartVo(orderItemVoList);
    }


    @Transactional
    @Override
    public String confirm(String username, String successUrl, String cancelUrl) {
        CartVo cartVo = getCart(username);
        Amount amount = new Amount();
        amount.setTotal(String.format("%.2f", cartVo.getCartTotalPrice()
                .setScale(cartVo.getTotalCount(), RoundingMode.HALF_UP).doubleValue()));
        amount.setCurrency("CAD");
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        Payment payment = new Payment("sale", payer);
        payment.setTransactions(Collections.singletonList(transaction));
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("https://localhost/order/" + cancelUrl);
        redirectUrls.setReturnUrl("https://localhost/order/" + successUrl);
        payment.setRedirectUrls(redirectUrls);
        try {
            Payment createdPayment = payment.create(apiContext);
            for (Links link : createdPayment.getLinks()) {
                if ("approval_url".equals(link.getRel())) {
                    //token for preventing duplicate orders
                    stringRedisTemplate.opsForValue().set(RedisCommon.USER_CONFIRM_ORDER_PREFIX + username,
                            createdPayment.getId(), 30, TimeUnit.MINUTES);
                    return link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCart(String token, String username) {
        compareAndDeleteOrderToken(username, token);
        redisTemplate.delete(RedisCommon.USER_CART_PREFIX + username);
    }

    @Transactional
    @Override
    public boolean executePayment(String paymentId, String payerId, String token) {
        UserTo user = (UserTo) redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX + token);
        String username = user.getUsername();
        if (compareAndDeleteOrderToken(username, paymentId) == 0L) {
            return false;
        }
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
        CompletableFuture<Boolean> paymentFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Payment execute = payment.execute(apiContext, paymentExecution);
                return execute.getPayer().getPayerInfo().getEmail();
            } catch (PayPalRESTException e) {
                e.printStackTrace();
                return null;
            }
        }, executor).thenApply((email) -> {
            if (email == null) {
                return false;
            }
            thirdpartyFeignService.send(email,
                    MessageContent.PURCHASE_SUCCESS_TITLE,
                    MessageContent.PURCHASE_SUCCESS_CONTENT);
            return true;
        });
        CartVo cartVo = getCart(username);
        cartVo.setPaypalPaymentId(paymentId);
        Order order = new Order();
        order.setProductCount(cartVo.getTotalCount());
        order.setPaymentId(cartVo.getPaypalPaymentId());
        order.setTotalPrice(cartVo.getCartTotalPrice().doubleValue());
        order.setUserId(user.getId());
        baseMapper.insert(order);
        cartVo.setUserId(user.getId());
        orderItemService.saveBatch(cartVo, order.getId());
        deleteCart(paymentId, username);
        CompletableFuture<R> updateSaleFuture = CompletableFuture
                .supplyAsync(() -> bookFeignService.updateSale(1, cartVo.getOrderItemVoList()
                        .stream().map(OrderItemVo::getId).collect(Collectors.toList())));
        CompletableFuture.allOf(paymentFuture, updateSaleFuture);
        try {
            return updateSaleFuture.get().isSuccess() && paymentFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }


    private Long compareAndDeleteOrderToken(String username, String orderToken) {
        //lua script to ensure atomicity
        String script = "if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        return stringRedisTemplate.execute(new DefaultRedisScript<>(script, Long.class),
                Collections.singletonList(RedisCommon.USER_CONFIRM_ORDER_PREFIX + username),
                orderToken);
    }


}
