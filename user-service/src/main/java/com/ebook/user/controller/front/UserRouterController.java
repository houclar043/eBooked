package com.ebook.user.controller.front;

import com.ebook.common.To.UserTo;
import com.ebook.common.common.BookStatus;
import com.ebook.common.utils.CookieUtil;
import com.ebook.common.common.GlobalPage;
import com.ebook.common.common.RedisCommon;
import com.ebook.common.entity.Book;
import com.ebook.user.entity.vo.UserInfoVo;
import com.ebook.user.feign.BookFeignService;
import com.ebook.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @Author: Cliffe
 * @Date: 2022-10-19 3:22 下午
 */
@Controller
@RequestMapping("user/page")
public class UserRouterController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private IUserService userService;

    @Autowired
    private BookFeignService bookFeignService;

    @RequestMapping("message")
    public String message(Model model, HttpServletRequest request){
        model.addAttribute("user", getUser(request));
        return "message";
    }

    @RequestMapping("profile")
    public String profile(Model model, HttpServletRequest request){
        UserInfoVo userInfoVo = userService.getUserInfoVo(request);
        model.addAttribute("user", userInfoVo);
        return "profile";
    }

    @RequestMapping("review/{bookId}/{hashKey}")
    public String reviewPage(HttpServletRequest request,
                             @PathVariable("bookId") long bookId,
                             @PathVariable("hashKey") String hashKey,
                             Model model){
        UserTo user = getUser(request);
        Book book = userService.canView(user.getId(), bookId);
        if(book == null){
            return "redirect:"+GlobalPage.NO_AUTH_PAGE;
        }
        if(book.getStatus() != BookStatus.UNDER_REVIEW_STATUS){
            redisTemplate.opsForHash().delete(RedisCommon.USER_UNREAD_MESSAGE_PREFIX + user.getId(), hashKey);
            return book.getStatus() == BookStatus.PUBLIC_STATUS ?
                    "redirect:https://localhost/book/item/detail/"+bookId : "redirect:"+GlobalPage.NO_AUTH_PAGE;
        }
        if(!user.getUsername().equals(book.getAuthor())){
            model.addAttribute("reviewer", user);
        }
        model.addAttribute("book", book);
        model.addAttribute("hashKey", hashKey);
        return "review";
    }

    @RequestMapping("profile/public/{userId}")
    public String publicProfile(@PathVariable("userId") long userId, Model model){
        model.addAttribute("user", userService.getPublicProfile(userId));
        return "publicProfile";
    }

    private UserTo getUser(HttpServletRequest request){
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        return (UserTo) redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX+token);
    }
}
