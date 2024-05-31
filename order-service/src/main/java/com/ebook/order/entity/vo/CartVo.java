package com.ebook.order.entity.vo;

import com.ebook.common.vo.OrderItemVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cliffe
 * @Date: 2022-10-20 10:59 上午
 */
@Data
public class CartVo {

    private List<OrderItemVo> orderItemVoList;

    private Long userId;

    private BigDecimal cartTotalPrice;

    private int totalCount;

    private String paypalPaymentId;

    private String approveUrl;

    private boolean isCreated;

    public CartVo() {
        cartTotalPrice = BigDecimal.ZERO;
        orderItemVoList = new ArrayList<>();
    }

    public CartVo(List<OrderItemVo> orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
        totalCount = orderItemVoList.size();
        cartTotalPrice = getCartTotalPrice();
    }

    public BigDecimal getCartTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItemVo orderItemVo : orderItemVoList) {
            total = total.add(BigDecimal.valueOf(orderItemVo.getPrice()));
        }
        return total;
    }
}
