package com.ebook.order.controller.rest;


import com.ebook.common.common.R;
import com.ebook.common.vo.OrderItemVo;
import com.ebook.order.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  rest controller
 * </p>
 *
 * @author yuhan
 * @since 2022-10-05
 */
@RestController
@RequestMapping("/rest/order/item")
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    /**
     * return a list of bookId which have been purchased by user already
     * return empty list if no result
     */
    @RequestMapping("hasPurchased")
    public R hasPurchased(@RequestParam("bookId") Long bookIdList,
                  @RequestParam("userId") Long userId){
        Boolean purchased = orderItemService.hasPurchased(bookIdList, userId);
        return R.ok().data("purchased", purchased);
    }


    @RequestMapping("getOrderItemList")
    public R getOrderItemListByUserId(@RequestParam("userId") long userId){
        List<OrderItemVo> list = orderItemService.getByUserId(userId);
        return R.ok().data("orderItemList", list);
    }
}

