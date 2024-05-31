package com.ebook.thirdparty.controller;

import com.ebook.common.common.R;
import com.ebook.common.common.ResultCode;
import com.ebook.thirdparty.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cliffe
 * @Date: 2022-09-27 3:41 下午
 */
@RestController
@RequestMapping("/rest/thirdparty/mail")
public class


MailController {

    @Autowired
    IMailService mailService;

    @RequestMapping(value = "send")
    public R send(@RequestParam("mail") String to, @RequestParam("title") String title,
                  @RequestParam("content") String content) {
        boolean sended = mailService.send(to, title, content);
        return sended ? R.ok() : R.error(ResultCode.THIRD_PARTY_SERVICE_EXCEPTION)
                .message("send mail error!");
    }
}
