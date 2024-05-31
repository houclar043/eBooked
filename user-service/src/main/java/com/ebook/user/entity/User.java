package com.ebook.user.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * user table
 * </p>
 *
 * @author yuhan
 * @since 2022-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * username
     */
    private String username;

    /**
     * nickname
     */
    private String nickname;

    /**
     * password
     */
    private String password;

    /**
     * status（0 normal 1 disabled）
     */
    private String status;

    /**
     * email
     */
    private String email;

    /**
     * user gender（0 female，1 male，2 unkown）
     */
    private String gender;

    /**
     * avatar
     */
    private String avatar;

    /**
     * role: either be student or professor
     * 0: student
     * 1: student from UofT
     * 2: teacher
     * 3: admins
     */
    int type;

    /**
     * create time
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * update time
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * is account deleted（0 not deleted，1 deleted）
     */
    private Integer delFlag;

}
