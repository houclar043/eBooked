package com.ebook.user.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ebook.common.utils.MD5;
import com.ebook.user.entity.User;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: Cliffe
 * @Date: 2022-09-28 9:03 上午
 */
@SpringBootTest
class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    void register() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "yuhan");
        map.put("password", "yuhan");
        map.put("nickname", "yuhan");
        userService.register(map);
    }

    @Test
    void insertUser(){
        for (User user : userService.list(null)) {
            if(user.getPassword().equals("NULL")){
                user.setPassword(MD5.encrypt(user.getUsername()));
                userService.updateById(user);
            }
        }
    }
}