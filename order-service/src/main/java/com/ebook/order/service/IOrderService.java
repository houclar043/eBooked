package com.ebook.order.service;

import com.ebook.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ebook.order.entity.vo.CartVo;

/**
 * <p>
 *  service class
 * </p>
 *
 * @author yuhan
 * @since 2022-10-05
 */
public interface IOrderService extends IService<Order> {

    CartVo getCart(String username);

    String confirm(String username, String successUrl, String cancelUrl);

    void deleteCart(String token, String username);

    boolean executePayment(String paymentId, String payerId, String token);

}
