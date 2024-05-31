package com.ebook.order.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhan
 * @since 2022-10-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`order`")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private long id;

    /**
     * Unique id for this order
     */
    private String paymentId;

    /**
     * User id
     */
    private Long userId;

    private Integer productCount;

    /**
     * Total price
     */
    private Double totalPrice;

    /**
     * 0-> to be paid; 
        1-> in process;
        2-> Completed;
        3-> Closed;
        4-> Invalid order
     */
    private Integer orderStatus;

    /**
     * Time when the order is created
     */
    private LocalDateTime createTime;


}
