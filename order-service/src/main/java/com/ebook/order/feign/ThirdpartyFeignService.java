package com.ebook.order.feign;

import com.ebook.common.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Cliffe
 * @Date: 2022-10-22 2:14 下午
 */
@FeignClient("thirdparty-service")
public interface ThirdpartyFeignService {

    @RequestMapping("rest/thirdparty/mail/send")
    R send(@RequestParam("mail") String to, @RequestParam("title")String title,
                  @RequestParam("content")String content);

}
