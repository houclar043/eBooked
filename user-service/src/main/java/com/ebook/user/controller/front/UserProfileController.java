package com.ebook.user.controller.front;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ebook.common.To.UserTo;
import com.ebook.common.utils.CookieUtil;
import com.ebook.common.common.R;
import com.ebook.common.common.RedisCommon;
import com.ebook.common.vo.MessageVo;
import com.ebook.common.entity.Book;
import com.ebook.user.entity.Tag;
import com.ebook.user.entity.vo.SectionVo;
import com.ebook.user.feign.BookFeignService;
import com.ebook.user.service.ITagService;
import com.ebook.user.service.IUserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Cliffe
 * @Date: 2022-10-22 4:18 下午
 */
@Controller
@RequestMapping("user/profile")
public class UserProfileController {

    @Autowired
    private RedisCommon redisCommon;

    @Autowired
    private BookFeignService bookFeignService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private ITagService tagService;

    @Autowired
    private IUserTagService userTagService;

    private final int RECENT_MESSAGE_COUNT = 10;

    @GetMapping("getMessage")
    public String getMessage(@RequestParam("userId") Long userId,
                             Model model) {
        Map<String, MessageVo> map = redisCommon.getHash(RedisCommon.USER_UNREAD_MESSAGE_PREFIX + userId);
        List<MessageVo> messageList = new ArrayList<>();
        for (Map.Entry<String, MessageVo> entry : map.entrySet()) {
            messageList.add(JSON.parseObject(JSON.toJSONString(entry.getValue()), MessageVo.class));
        }
        if (messageList.isEmpty()) {
            R res = bookFeignService.getRecentComment(userId, RECENT_MESSAGE_COUNT);
            messageList = JSON.parseObject(JSON.toJSONString(res.getData().get("messageVoList")),
                    new TypeReference<List<MessageVo>>() {
                    });
        }
        model.addAttribute("messageList", messageList);
        return "profile :: #messageList";
    }

    @RequestMapping("public/getTags")
    public String getTagsPublic(@RequestParam("userId") Long userId, Model model) {
        List<Tag> tagList = userTagService.getTags(userId);
        model.addAttribute("tagList", tagList);
        return "publicProfile :: #tagList";
    }

    @RequestMapping("getTags")
    public String getTags(@RequestParam("userId") Long userId, Model model) {
        List<Tag> tagList = userTagService.getTags(userId);
        model.addAttribute("tagList", tagList);
        return "profile :: #tagList";
    }

    @RequestMapping("public/getUploads")
    public String getUploadsPublic(@RequestParam("username") String username, Model model) {
        R r = bookFeignService.getBookByAuthor(username);
        List<Book> bookList = JSON.parseObject(JSON.toJSONString(r.getData()
                .get("bookList")), new TypeReference<List<Book>>() {
        });
        model.addAttribute("bookList", bookList);
        return "publicProfile :: #bookList";
    }

    @RequestMapping("getUploads")
    public String getUploads(@RequestParam("username") String username, Model model) {
        R r = bookFeignService.getBookByAuthor(username);
        List<Book> bookList = JSON.parseObject(JSON.toJSONString(r.getData()
                .get("bookList")), new TypeReference<List<Book>>() {
        });
        model.addAttribute("bookList", bookList);
        return "profile :: #bookList";
    }

    @GetMapping("upload")
    public String upload(HttpServletRequest request, Model model) {
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        UserTo user = (UserTo) redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX + token);
        model.addAttribute("user", user);
        model.addAttribute("tagList", tagService.list());
        R res = bookFeignService.getSections();
        List<SectionVo> sectionList = JSON.parseObject(JSON.toJSONString(res.getData().get("sectionList"))
                , new TypeReference<List<SectionVo>>() {
                });
        model.addAttribute("sectionList", sectionList);
        return "upload";
    }

//    @GetMapping("addProfessor")
//    public String addProfessor(HttpServletRequest request){
//        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
//        UserTo user = (UserTo) redisTemplate.opsForValue().get(token);
//        int type = userService.getType(user.getId());
////        if(type == UserType.)
//    }
}
