package com.ebook.thirdparty.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Cliffe
 * @Date: 2022-11-18 11:48 上午
 */
@SpringBootTest
class IAWSServiceTest {

    @Autowired
    private IAWSService awsService;

    @Test
    void deleteFile() {
        awsService.deleteFile("upload/2022-11-17/491c92c52140499894d5396c9081fbf6default-book-cover.png");
    }
}