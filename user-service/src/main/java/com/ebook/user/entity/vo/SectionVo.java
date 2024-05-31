package com.ebook.user.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhan
 * @since 2022-10-05
 */
@Data
public class SectionVo implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String sectionName;

    private Long createdBy;

    private Long updatedBy;

    /**
     * 0: normal,
        1: disabled
     */
    private Integer isDisabled;

    private Date createTime;

    private Date updateTime;


}
