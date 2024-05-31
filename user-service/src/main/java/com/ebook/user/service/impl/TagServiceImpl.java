package com.ebook.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ebook.user.dao.TagDao;
import com.ebook.user.entity.Tag;
import com.ebook.user.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  service impl
 * </p>
 *
 * @author yuhan
 * @since 2022-09-28
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements ITagService {


    @Override
    public List<String> getTagNameByUserId(long id, int i) {
        QueryWrapper<Tag> wrapper = new QueryWrapper<Tag>().eq("create_by", id);
        if(i != -1){
            wrapper.last("limit "+ i);
        }
        return list(wrapper).stream().map(Tag::getTagName).collect(Collectors.toList());
    }
}
