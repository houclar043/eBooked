package com.ebook.thirdparty.utils;

import com.ebook.thirdparty.service.IMailService;
import com.ebook.thirdparty.service.impl.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Cliffe
 * @Date: 2022-09-27 4:39 下午
 */
@SpringBootTest
class MailClientTest {

    @Autowired
    IMailService mailService;

    @Test
    void sendMail() {
        mailService.send("yuhanyao9@gmail.com", "test", "test");
    }
}