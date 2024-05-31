package com.ebook.user.dao;

import com.ebook.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * user table Mapper interface
 * </p>
 *
 * @author yuhan
 * @since 2022-09-13
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
