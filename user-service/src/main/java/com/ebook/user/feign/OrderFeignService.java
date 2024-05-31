package com.ebook.user.feign;

import com.ebook.common.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Cliffe
 * @Date: 2022-10-22 2:29 下午
 */
@FeignClient("order-service")
public interface OrderFeignService {

    @RequestMapping("/rest/order/item/hasPurchased")
    R hasPurchased(@RequestParam("bookId") Long bookId,
                         @RequestParam("userId") Long userId);
}
