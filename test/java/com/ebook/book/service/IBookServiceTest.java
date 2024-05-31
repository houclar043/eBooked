package com.ebook.book.service;

import com.alibaba.fastjson.JSONObject;
import com.ebook.book.entity.Book;
import com.ebook.common.vo.QueryVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Cliffe
 * @Date: 2022-10-05 10:45 上午
 */
@SpringBootTest
class IBookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void getByPage() {
        System.out.println(bookService.getByPage(new QueryVo()));
    }


}