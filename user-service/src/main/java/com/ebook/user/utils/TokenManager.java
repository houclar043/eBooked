package com.ebook.user.utils;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * util class for spring security
 * @Author: Cliffe
 * @Date: 2022-09-25 9:45 上午
 */
@Component
public class TokenManager {

    //token valid time
    private static long tokenExpiration = 24*60*60*1000;

    //encoding key
    private static String tokenSignKey = UUID.randomUUID().toString();

    /**
     * Generate token by username
     */
    public static String createToken(String password){
        return Jwts.builder().setSubject(password)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS256, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP).compact();
    }


    /**
     * parse token
     * get user password by token
     */
    public static String parseToken(String token){
        return Jwts.parser().setSigningKey(tokenSignKey)
                .parseClaimsJws(token).getBody().getSubject();
    }


    /**
     * remove token
     */
    public static boolean removeToken(String token){
        return true;
    }

}
