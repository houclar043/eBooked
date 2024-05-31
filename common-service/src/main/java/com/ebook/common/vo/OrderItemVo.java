package com.ebook.common.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Cliffe
 * @Date: 2022-10-20 10:51 上午
 */
@Data
public class OrderItemVo implements Serializable {

    private static final long serialVersionUID=1L;

    //bookId
    private long id;

    private String title;

    private String author;

    private Double price;

    private String cover;

    private String source;

}
