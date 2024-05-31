package com.ebook.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Primary;

/**
 * <p>
 *
 * </p>
 *
 * @author yuhan
 * @since 2022-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tag")
public class Tag implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    private long id;

    private String tagName;

    /**
     * 0: disabled
     * 1: in using
     */
    private String isDisabled;

    /**
     * creator’s id
     */
    private Long createBy;

    /**
     * updator’s id
     */
    private Long updateBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
