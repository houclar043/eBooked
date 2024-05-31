package com.ebook.user.entity.vo;

import com.ebook.user.entity.Tag;
import com.ebook.user.entity.User;
import lombok.Data;

import java.util.List;

/**
 * userVo for registration
 * @Author: Cliffe
 * @Date: 2022-10-04 6:51 下午
 */
@Data
public class UserInfoVo extends User {

    private List<Long> tagIdList;

    private List<String> tageNameList;


}

