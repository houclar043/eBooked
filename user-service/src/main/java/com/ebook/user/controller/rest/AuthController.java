package com.ebook.user.controller.rest;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ebook.common.common.R;
import com.ebook.common.common.ResultCode;
import com.ebook.common.utils.*;
import com.ebook.user.entity.User;
import com.ebook.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Cliffe
 * @Date: 2022-09-27 4:34 下午
 */
@RestController
@RequestMapping("/rest/user/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    private static final int VALID_CODE_TIME = 60*5;

    public static final String VERIFY_CODE_KEY = "code";


    /**
     * send verification code to valid UofT email address
     * then put encrypted code into cookie for verification
     */
    @GetMapping("sendCode")
    public R sendCode(@RequestParam("mail")String mail, HttpServletResponse response, HttpServletRequest request){
        R res = userService.sendCode(mail);
        if(res.getCode() == ResultCode.SUCCESS){
            CookieUtil.addCookie(response, request, VERIFY_CODE_KEY, VALID_CODE_TIME,
                    (String) res.getData().get(VERIFY_CODE_KEY));
        }
        return res;
    }

    @PostMapping("register")
    public R register(@RequestBody Map<String, Object> map, HttpServletRequest request,
                      HttpServletResponse response){
        if(request.getCookies() == null){
            return R.error(ResultCode.USER_SERVICE_EXCEPTION).message("Verification Failed!");
        }
        String code = CookieUtil.getCookie(request, "code");
        if(!StringUtils.isBlank(code)){
            if(!MD5.encrypt((String) map.get(VERIFY_CODE_KEY)).equals(code)){
                return R.error(ResultCode.USER_SERVICE_EXCEPTION).message("wrong verification code!");
            }
            String jwtToken = userService.register(map);
            if(StringUtils.isBlank(jwtToken)){
                //remove verification code cookie
                CookieUtil.removeCookie(request, response, VERIFY_CODE_KEY);
                //return user token
                return R.ok().data("token", jwtToken);
            }
        }
        return R.error(ResultCode.USER_SERVICE_EXCEPTION).message("username or email address has been used!");
    }

    @PostMapping("login")
    public R login(@RequestBody User user, HttpServletRequest request){
        if(CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY) != null){
            return R.ok().code(ResultCode.USER_ALREADY_LOGIN);
        }
        String jwtToken = userService.login(user);
        if(StringUtils.isBlank(jwtToken)){
            return R.error().message("wrong username/email or password!");
        }
        return R.ok().message("login success!").data("token", jwtToken);
    }
}
