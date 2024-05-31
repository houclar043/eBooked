package com.ebook.common.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ebook.common.To.UserTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.awt.print.PageFormat;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Cliffe
 * @Date: 2022-10-13 10:52 上午
 */
@Component
public class RedisCommon {

    public static final String USER_JWT_TOKEN_PREFIX = "ebook:jwt:token:";
    public static final String BOOK_RATE_CACHE_PREFIX = "ebook:rate:";
    public static final long BOOK_RATE_TIMEOUT_MINUTE = 60;
    public static final long USER_TOKEN_EXPIRE_TIME_MINUTE = 60;
    public static final String FRONT_PAGE_BOOK_CACHE_PREFIX = "ebook:index:book";
    public static final String FRONT_PAGE_USER_CACHE_PREFIX = "ebook:index:user";
    public static final String FRONT_PAGE_SECTION_CACHE_PREFIX = "ebook:index:section";
    public static final long FRONT_PAGE_TIMEOUT_MINUTE = 30;
    public static final String USER_CART_PREFIX = "ebook:cart:";
    public static final String USER_CONFIRM_ORDER_PREFIX = "ebook:order:";
    public static final String USER_UNREAD_MESSAGE_PREFIX = "ebook:message:unread:";

    @Resource
    public RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    public RedisTemplate<String, Serializable> redisTemplate;


    /**
     *
     * @param key
     * @param values
     * @param expire -1: no expire
     * @param <T>
     */
    public <T> void setList(String key, List<T> values, long expire, TimeUnit timeUnit){
        for (T value : values) {
            String s = JSON.toJSONString(value);
            stringRedisTemplate.opsForList().rightPush(key, s);
        }
        stringRedisTemplate.opsForList().getOperations().expire(key, expire, timeUnit);
    }

    public <T> void setPage(Page<T> page, String key, long expire, TimeUnit timeUnit){
        List<T> records = page.getRecords();
        //prevent JSON deserialize error
        page.setRecords(new ArrayList<>(records.subList(0, records.size())));
        redisTemplate.opsForValue().set(key, page, expire, timeUnit);
    }

    public <T> List<T> getList(String key){
        List<String> list;
        try {
            list = stringRedisTemplate.opsForList().range(key, 0, -1);
        } catch (Exception e) {
            return null;
        }
        List<T> res = new ArrayList<>();
        for (String s : list) {
            try {
                res.add(JSON.parseObject(s, new TypeReference<T>() {
                }));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return res;
    }

    public <T> Map<String, T> getHash(String key){
        Map<String, T> map = new HashMap<>();
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
        for (Map.Entry<Object, Object> entry : entries.entrySet()) {
            map.put((String)entry.getKey(), JSON.parseObject(JSON.toJSONString(entry.getValue()), new TypeReference<T>(){}));
        }
        return map;
    }

}
