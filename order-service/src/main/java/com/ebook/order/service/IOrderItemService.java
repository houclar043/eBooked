package com.ebook.order.service;

import com.ebook.common.vo.OrderItemVo;
import com.ebook.order.entity.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ebook.order.entity.vo.CartVo;

import java.util.List;

/**
 * <p>
 *  service class
 * </p>
 *
 * @author yuhan
 * @since 2022-10-05
 */
public interface IOrderItemService extends IService<OrderItem> {

    void saveBatch(CartVo cartVo, long orderId);

    Boolean hasPurchased(Long bookId, Long userId);

    List<OrderItemVo> getByUserId(long userId);

}
