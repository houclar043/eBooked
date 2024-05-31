package com.ebook.user.controller.front;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ebook.common.utils.CookieUtil;
import com.ebook.common.common.RedisCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/** /index controller
 * @Author: Cliffe
 * @Date: 2022-09-26 8:45 上午
 */
@Controller
@RequestMapping("user")
public class UserMainController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @GetMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        CookieUtil.removeCookie(request, response, CookieUtil.COOKIE_USER_KEY);
        if(!StringUtils.isBlank(token)){
            redisTemplate.delete(RedisCommon.USER_JWT_TOKEN_PREFIX+token);
        }
        return "redirect:https://localhost";
    }
}
