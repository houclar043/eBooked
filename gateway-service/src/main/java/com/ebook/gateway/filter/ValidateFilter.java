package com.ebook.gateway.filter;

import com.ebook.common.utils.CookieUtil;
import com.ebook.common.common.RedisCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: Cliffe
 * @Date: 2022-10-12 3:49 下午
 */
@Component
public class ValidateFilter implements GlobalFilter, Ordered {

    private final String[] NEED_LOGIN_URI = {"/rest/**", "/order/**", "/user/**"};

    private final String[] NO_NEED_LOGIN_URI = {"/*/static/**", "/rest/user/auth/*",
            "/user/login", "/user/register", "/user/page/profile/public/*", "/book/item/detail/*"};


    @Autowired
    AntPathMatcher pathMatcher(){
        return new AntPathMatcher();
    }

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if(inPath(path, NO_NEED_LOGIN_URI)){
            return chain.filter(exchange);
        }
        if(path != null && !inPath(path, NEED_LOGIN_URI)){
            return chain.filter(exchange);
        }
        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        for (Map.Entry<String, List<HttpCookie>> entry : cookies.entrySet()) {
            List<HttpCookie> v = entry.getValue();
            for (HttpCookie cookie : v) {
                if(cookie.getName().equals(CookieUtil.COOKIE_USER_KEY) &&
                        redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX + cookie.getValue()) != null){
                    return chain.filter(exchange);
                }
            }
        }
        //redirect
        String url = "https://localhost/user/login";
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.SEE_OTHER);
        response.getHeaders().set(HttpHeaders.LOCATION, url);
        return response.setComplete();
    }

    private boolean inPath(String path, String[] arr) {
        for (String s : arr) {
            if(pathMatcher().match(s, path)){
                return true;
            }
        }
        return false;
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
