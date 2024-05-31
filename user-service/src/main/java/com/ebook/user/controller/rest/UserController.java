package com.ebook.user.controller.rest;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ebook.common.To.UserTo;
import com.ebook.common.utils.CookieUtil;
import com.ebook.common.common.RedisCommon;
import com.ebook.common.vo.AmazonFileVo;
import com.ebook.common.vo.QueryVo;
import com.ebook.common.vo.UserVo;
import com.ebook.common.entity.Book;
import com.ebook.user.service.IUserService;
import com.ebook.common.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * user table front controller
 * </p>
 *
 * @author yuhan
 * @since 2022-09-13
 */
@RestController
@RequestMapping("/rest/user")
@SuppressWarnings("all")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @PostMapping("getPagedUser")
    public R getPagedUser(@RequestBody QueryVo queryVo){
        Page<UserVo> userVoPage = userService.getPage(queryVo);
        return R.ok().data("userVoPage", userVoPage);
    }

    @RequestMapping("addToCart")
    public R addToCart(@RequestParam("bookId") long bookId, HttpServletRequest request){
        return userService.addToCart(bookId, request) ? R.ok() : R.error();
    }

    @RequestMapping( "uploadFile")
    public R uploadFile(@RequestParam("file") MultipartFile file,
                    @RequestParam(value = "cover", required = false) MultipartFile cover){
        Map<String, AmazonFileVo> map = userService.uploadFile(file, cover);
        return map != null ? R.ok().data("map", map) : R.error();
    }

    @RequestMapping("saveBook")
    public R saveBook(@RequestBody Map<String, Object> params, HttpServletRequest request){
        Book book = JSON.parseObject(JSON.toJSONString(params.get("book")), Book.class);
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        UserTo user = (UserTo) redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX+token);
        List<Long> sectionIdList = new ArrayList<>();
        for (ArrayList arr : (List<ArrayList>) params.get("sectionIds")) {
            sectionIdList.add(Long.parseLong((String)(arr.get(0))));
        }
        boolean saved = userService.saveBook(book, user.getId(), sectionIdList);
        return saved ? R.ok() : R.error();
    }


    @RequestMapping("reviewResult")
    public R reviewResult(@RequestBody Map<String, Object> params, HttpServletRequest request){
        boolean isApproved = (boolean)params.get("isApproved");
        long bookId = Long.parseLong((String)params.get("bookId"));
        String hashKey = (String)params.get("hashKey");
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        UserTo user = (UserTo) redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX+token);
        return userService.reviewResult(isApproved, user, bookId) ? R.ok() : R.error();
    }
}

