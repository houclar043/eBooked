package com.ebook.user.service;

import com.ebook.common.To.UserTo;
import com.ebook.common.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

/**
 * @Author: Cliffe
 * @Date: 2022-10-11 9:56 上午
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void testString(){
        stringRedisTemplate.opsForValue().set("test", "test");
        System.out.println(stringRedisTemplate.opsForValue().get("test"));
    }

    @Test
    public void testSerializable() {
        UserTo user=new UserTo();
        user.setId(1L);
        user.setUsername("cliffe");
        user.setNickname("cliffe");
        serializableRedisTemplate.opsForValue().set("user", user);
        UserTo user2 = (UserTo) serializableRedisTemplate.opsForValue().get("user");
        System.out.println("user:"+user2.getId()+","+user2.getUsername()+","+user2.getNickname());
    }

}
