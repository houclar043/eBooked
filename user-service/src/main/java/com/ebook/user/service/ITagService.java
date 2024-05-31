package com.ebook.user.service;

import com.ebook.user.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  service
 * </p>
 *
 * @author yuhan
 * @since 2022-09-28
 */
public interface ITagService extends IService<Tag> {

    List<String> getTagNameByUserId(long id, int i);
}
