package com.ebook.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebook.user.entity.Tag;
import com.ebook.user.entity.UserTag;
import com.ebook.user.service.ITagService;
import com.ebook.user.service.IUserTagService;
import com.ebook.user.dao.UserTagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author yuhan
* @description 针对表【user_tag】的数据库操作Service实现
* @createDate 2022-11-23 15:07:44
*/
@Service
public class IUserTagServiceImpl extends ServiceImpl<UserTagDao, UserTag>
    implements IUserTagService {

    @Autowired
    private ITagService tagService;

    @Override
    public List<Tag> getTags(Long userId) {
        return list(new QueryWrapper<UserTag>().eq("user_id", userId))
                .stream().map((userTag -> tagService.getById(userTag.getTagId())))
                .collect(Collectors.toList());
    }
}




