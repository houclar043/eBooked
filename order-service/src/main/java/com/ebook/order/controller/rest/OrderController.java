package com.ebook.order.controller.rest;


import com.ebook.common.common.R;
import com.ebook.common.common.RedisCommon;
import com.ebook.common.vo.OrderItemVo;
import com.ebook.order.config.PayPalConfig;
import com.ebook.order.entity.OrderItem;
import com.ebook.order.service.IOrderItemService;
import com.ebook.order.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuhan
 * @since 2022-10-05
 */
@RestController
@RequestMapping("/rest/order")
public class OrderController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private IOrderService orderService;

    @GetMapping("remove")
    public R remove(@RequestParam("bookId") Long bookId,
                    @RequestParam("username") String username){
        Long res = 0L;
        try {
            res = stringRedisTemplate.opsForSet().remove(RedisCommon.USER_CART_PREFIX + username,
                    String.valueOf(bookId));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
        return res == 1 ? R.ok() : R.error();
    }

    /**
     * paypal authorization method
     */
    @GetMapping("confirm")
    public R confirm(@RequestParam("username")String username){
        String redirectUrl = orderService.confirm(username , PayPalConfig.SUCCESS_URL, PayPalConfig.CANCEL_URL);
        return redirectUrl != null ? R.ok().data("redirectUrl", redirectUrl) : R.error();
    }
}

