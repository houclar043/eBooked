package com.ebook.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Long bookId;

    private String title;

    private String author;

    private String cover;

}
