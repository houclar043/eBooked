package com.ebook.thirdparty.service;

/**
 * @Author: Cliffe
 * @Date: 2022-09-27 3:59 下午
 */
public interface IMailService {
    boolean send(String to, String title, String content);
}
