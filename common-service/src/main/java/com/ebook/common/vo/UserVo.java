package com.ebook.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: Cliffe
 * @Date: 2022-10-08 11:09 上午
 */
@Data
public class UserVo {

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
    private int type;

    private List<String> tags;
}
