package com.ebook.order.feign;

import com.ebook.common.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Cliffe
 * @Date: 2022-10-20 11:18 上午
 */
@FeignClient("book-service")
@Component
public interface BookFeignService {

    @RequestMapping("/rest/book/book/wrapOrderItemVo")
    R wrapOrderItemVo(@RequestBody List<Long> bookIdList);


    @RequestMapping("/rest/book/book/updateSale")
    R updateSale(@RequestParam("count")int count, @RequestBody List<Long> bookIdList);
}


