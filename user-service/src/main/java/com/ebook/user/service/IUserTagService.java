package com.ebook.user.service;

import com.ebook.user.entity.Tag;
import com.ebook.user.entity.UserTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yuhan
* @description 针对表【user_tag】的数据库操作Service
* @createDate 2022-11-23 15:07:44
*/
public interface IUserTagService extends IService<UserTag> {

    List<Tag> getTags(Long userId);
}
