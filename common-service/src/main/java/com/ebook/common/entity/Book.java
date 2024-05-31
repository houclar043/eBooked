package com.ebook.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhan
 * @since 2022-09-28
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private Long tagId;

    private String title;

    private String author;

    private String publisher;

    private Double price;

    private Integer sales;

    private Integer status;

    private String cover;

    private String coverKeyname;

    private String description;

    private String source;

    private String sourceKeyname;

    private Date createTime;

    private Date updateTime;
}
