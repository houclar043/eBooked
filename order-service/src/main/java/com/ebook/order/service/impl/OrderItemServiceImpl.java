package com.ebook.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ebook.common.vo.OrderItemVo;
import com.ebook.order.entity.Order;
import com.ebook.order.entity.OrderItem;
import com.ebook.order.dao.OrderItemDao;
import com.ebook.order.entity.vo.CartVo;
import com.ebook.order.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  service impl class
 * </p>
 *
 * @author yuhan
 * @since 2022-10-05
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItem> implements IOrderItemService {

    @Override
    public void saveBatch(CartVo cartVo, long orderId) {
        List<OrderItem> orderItemList = cartVo.getOrderItemVoList().stream().map(orderItemVo -> {
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(orderItemVo, orderItem);
            orderItem.setOrderId(orderId);
            orderItem.setBookId(orderItemVo.getId());
            return orderItem;
        }).collect(Collectors.toList());
        saveBatch(orderItemList);
    }

    @Override
    public Boolean hasPurchased(Long bookId, Long userId) {
        return baseMapper.selectOne(new QueryWrapper<OrderItem>()
                .eq("book_id", bookId).eq("user_id", userId)) != null;
    }

    @Override
    public List<OrderItemVo> getByUserId(long userId){
        return list(new QueryWrapper<OrderItem>().eq("user_id", userId))
                .stream().map(orderItem -> {
            OrderItemVo orderItemVo = new OrderItemVo();
            BeanUtils.copyProperties(orderItem, orderItemVo);
            return orderItemVo;
        }).collect(Collectors.toList());
    }
}