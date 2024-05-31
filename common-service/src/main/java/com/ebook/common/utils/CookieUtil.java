package com.ebook.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.web.http.CookieSerializer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Cliffe
 * @Date: 2022-10-11 10:27 上午
 */
@Slf4j
public class CookieUtil {

    private static String DEFAULT_COOKIE_DOMAIN = "localhost";

    public static final int USER_COOKIE_EXPIRE_TIME = 60 * 60 * 24;
    /**
     * user key stores in cookie
     */
    public static final String COOKIE_USER_KEY = "token";
    /**
     * code key stores in cookie
     */
    public static final String VERIFY_CODE_KEY = "code";


    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("read cookieName:{}, cookieValue:{}", cookie.getName(), cookie.getValue());
                if (cookieName.equals(cookie.getName())) {
                    log.info("return cookieName:{}, cookieValue:{}", cookie.getName(), cookie.getValue());
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void addCookie(HttpServletResponse response, HttpServletRequest request,
                                 String cookieName, int expireTime, String value) {
        Cookie cookie  = new Cookie(cookieName, value);
        cookie.setDomain(DEFAULT_COOKIE_DOMAIN);
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        cookie.setPath("/");
        // Preventing script attacks
        cookie.setHttpOnly(true);
        // The unit is seconds. If it is -1, it means forever.
        // If MaxAge is not set, the cookie is not written to the hard disk,
        // but is in memory and only valid for the current page
        cookie.setMaxAge(expireTime);
        log.info("write cookieName:{}, cookieValue:{}, cookieDomain:{}, cookiePath:{}", cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath());
        response.addCookie(cookie);
    }

    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    cookie.setDomain(DEFAULT_COOKIE_DOMAIN);
                    cookie.setPath("/");
                    // If maxAge is set to 0, it will be deleted
                    cookie.setMaxAge(0);
                    log.info("del cookieName:{}, cookieValue:{}", cookie.getName(), cookie.getValue());
                    response.addCookie(cookie);
                    return;
                }
            }
        }
    }

}
