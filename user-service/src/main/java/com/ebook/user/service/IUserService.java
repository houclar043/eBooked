package com.ebook.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ebook.common.To.UserTo;
import com.ebook.common.vo.AmazonFileVo;
import com.ebook.common.vo.QueryVo;
import com.ebook.common.vo.UserVo;
import com.ebook.common.entity.Book;
import com.ebook.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ebook.common.common.R;
import com.ebook.user.entity.vo.UserInfoVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 service class
 * </p>
 *
 * @author yuhan
 * @since 2022-09-13
 */
public interface IUserService extends IService<User> {

    String login(User user);

    User getInfo(String token);

    boolean deleteByUserId(int userId);

    R sendCode(String email);

    String register(Map<String, Object> map);


    Page<UserVo> getPage(QueryVo queryVo);

    boolean addToCart(long bookId, HttpServletRequest request);

    UserInfoVo getUserInfoVo(HttpServletRequest request);

    Map<String, AmazonFileVo> uploadFile(MultipartFile file, MultipartFile cover);

    boolean saveBook(Book book, long userId, List<Long> sectionIds);

    Book canView(long id, long bookId);

    boolean reviewResult(boolean isApproved, UserTo user, long bookId);

    List<Book> getUploadHistory(long id);

    User getPublicProfile(long userId);
}
