package com.ebook.order.controller.front;

import com.ebook.common.To.UserTo;
import com.ebook.common.utils.CookieUtil;
import com.ebook.common.common.RedisCommon;
import com.ebook.order.config.PayPalConfig;
import com.ebook.order.entity.vo.CartVo;
import com.ebook.order.feign.ThirdpartyFeignService;
import com.ebook.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @Author: Cliffe
 * @Date: 2022-10-20 10:40 上午
 */
@Controller
@RequestMapping("order")
public class OrderRouterController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("cartList")
    public String orderList(Model model, HttpServletRequest request) {
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        UserTo user = (UserTo) redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX + token);
        CartVo cart = orderService.getCart(user.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "cartList";
    }

    @GetMapping(PayPalConfig.SUCCESS_URL)
    public String success(@RequestParam("paymentId") String paymentId,
                          @RequestParam("PayerID") String payerId, HttpServletRequest request) {
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        boolean executed = orderService.executePayment(paymentId, payerId, token);
        if (executed) {
            return "redirect:https://localhost/order/complete?res=sucess";
        }
        return "redirect:https://localhost/order/complete?res=failed";
    }

    @GetMapping(PayPalConfig.CANCEL_URL)
    public String cancel() {
        return "redirect:https://localhost/order/cartList";
    }

    @GetMapping("complete")
    public String complete(@RequestParam("res") String res, Model model, HttpServletRequest request) {
        model.addAttribute("res", res);
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        UserTo user = (UserTo) redisTemplate.opsForValue().get(token);
        model.addAttribute("user", user);
        return "complete";
    }

}
