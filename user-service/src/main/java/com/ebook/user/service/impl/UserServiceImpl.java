package com.ebook.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ebook.common.common.*;
import com.ebook.common.utils.*;
import com.ebook.common.vo.AmazonFileVo;
import com.ebook.common.vo.MessageVo;
import com.ebook.common.vo.QueryVo;
import com.ebook.common.vo.UserVo;
import com.ebook.user.common.UserType;
import com.ebook.common.entity.Book;
import com.ebook.user.entity.Tag;
import com.ebook.user.entity.User;
import com.ebook.user.entity.vo.UserInfoVo;
import com.ebook.user.feign.BookFeignService;
import com.ebook.user.feign.OrderFeignService;
import com.ebook.user.feign.ThirdPartyFeignService;
import com.ebook.user.dao.UserDao;
import com.ebook.user.service.ITagService;
import com.ebook.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebook.user.utils.TokenManager;
import com.ebook.common.To.UserTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 * user table service implement method
 * </p>
 *
 * @author yuhan
 * @since 2022-09-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    @Autowired
    private ThirdPartyFeignService thirdPartyFeignService;

    @Autowired
    private ITagService tagService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private OrderFeignService orderFeignService;

    @Autowired
    private BookFeignService bookFeignService;

    @Autowired
    private ThreadPoolExecutor executor;

    @Override
    public User getInfo(String token) {
        String username = TokenManager.parseToken(token);
        return baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public String login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername())
                .or().eq("email", user.getEmail());
        User res = baseMapper.selectOne(wrapper);
        if(res == null || !res.getPassword().equals(MD5.encrypt(user.getPassword()))){
            return null;
        }
        UserTo userTo = new UserTo();
        BeanUtils.copyProperties(res, userTo);
        userTo.setJwtToken(TokenManager.createToken(user.getPassword()));
        redisTemplate.opsForValue().set(RedisCommon.USER_JWT_TOKEN_PREFIX+userTo.getJwtToken(), userTo, 60*24, TimeUnit.MINUTES);
        return userTo.getJwtToken();
    }

    @Override
    public boolean deleteByUserId(int userId) {
        User user = baseMapper.selectById(userId);
        if(user == null) {
            return false;
        }
        user.setDelFlag(1);
        return baseMapper.updateById(user) == 1;
    }

    @Override
    public String register(Map<String, Object> map) {
        UserInfoVo user = JSON.parseObject(JSON.toJSONString(map), UserInfoVo.class);
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("username", user.getUsername())
                .or().eq("email", user.getEmail());
        if(baseMapper.selectOne(wrapper) != null){
            return null;
        }
        user.setPassword(MD5.encrypt(user.getPassword()));
        User baseUser = new User();
        BeanUtils.copyProperties(user, baseUser);
        if(baseMapper.insert(baseUser) == 1){
            UserTo userTo = new UserTo();
            BeanUtils.copyProperties(user, userTo);
            userTo.setJwtToken(TokenManager.createToken(user.getPassword()));
            redisTemplate.opsForValue().set(RedisCommon.USER_JWT_TOKEN_PREFIX+userTo.getJwtToken(), userTo, 60*24, TimeUnit.MINUTES);
            return userTo.getJwtToken();
        }
        return null;
    }

    @Override
    public Page<UserVo> getPage(QueryVo queryVo) {
        int page = queryVo.getPage() == 0 ? CommonAttr.DEFAULT_PAGE : queryVo.getPage();
        int limit = queryVo.getLimit() == 0 ? CommonAttr.DEFAULT_PAGE_LIMIT: queryVo.getLimit();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(!StringUtils.isBlank(queryVo.getKeyword())){
            wrapper.like("username", queryVo.getKeyword())
                    .or().like("nickname", queryVo.getKeyword());
        }
        Page<User> userPage = baseMapper.selectPage(new Page<>(page, limit), wrapper);
        Page<UserVo> userVoPage = new Page<>();
        BeanUtils.copyProperties(userPage, userVoPage, "records");
        List<UserVo> userVoList = userPage.getRecords().stream().map(user -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            List<String> tagName = tagService.getTagNameByUserId(user.getId(),
                    CommonAttr.DEFAULT_TAG_COUNT);
            userVo.setTags(tagName);
            return userVo;
        }).collect(Collectors.toList());
        userVoPage.setRecords(userVoList);
        return userVoPage;
    }

    @Override
    public boolean addToCart(long bookId, HttpServletRequest request) {
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        UserTo user = (UserTo) redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX+token);
        Boolean purchased = JSON.parseObject(JSON.toJSONString(orderFeignService.hasPurchased(bookId,
                user.getId()).getData().get("purchased")), Boolean.class);
        if(purchased){
            return false;
        }
        return Objects.equals(stringRedisTemplate.opsForSet()
                .add(RedisCommon.USER_CART_PREFIX + user.getNickname(),
                String.valueOf(bookId)), 1L);
    }

    @Override
    public UserInfoVo getUserInfoVo(HttpServletRequest request) {
        String token = CookieUtil.getCookie(request, CookieUtil.COOKIE_USER_KEY);
        UserTo userTo = (UserTo) redisTemplate.opsForValue().get(RedisCommon.USER_JWT_TOKEN_PREFIX + token);
        User user = baseMapper.selectById(userTo.getId());
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(user, userInfoVo);
        userInfoVo.setPassword("");
        userInfoVo.setTageNameList(tagService.getTagNameByUserId(user.getId(), -1));
        return userInfoVo;
    }

    @Override
    public Map<String, AmazonFileVo> uploadFile(MultipartFile file, MultipartFile cover) {
        CompletableFuture<R> futureFileR = CompletableFuture.supplyAsync(() -> thirdPartyFeignService.upload(file, BookStatus.BOOK_UPLOADING_URL), executor);
        CompletableFuture<R> futureCoverR = null;
        if(cover != null){
            futureCoverR = CompletableFuture.supplyAsync(() -> thirdPartyFeignService.upload(cover, BookStatus.BOOK_UPLOADING_URL));
        }
        CompletableFuture.allOf(futureFileR, futureCoverR);
        R fileR, coverR = null;
        try {
            if((fileR = futureFileR.get()) == null
                    || (futureCoverR != null && (coverR = futureCoverR.get()) == null)){
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        Map<String, AmazonFileVo> map = new HashMap<>();
        AmazonFileVo amazonFileVo = JSON.parseObject(JSON.toJSONString(fileR.getData().get("fileModel")), AmazonFileVo.class);
        map.put("file", amazonFileVo);
        if(coverR != null){
            AmazonFileVo coverFileVo = JSON.parseObject(JSON.toJSONString(coverR.getData().get("fileModel")), AmazonFileVo.class);
            map.put("cover", coverFileVo);
        }
        return map;
    }

    @Override
    public boolean saveBook(Book book, long userId, List<Long> sectionIds) {
        User user = baseMapper.selectById(userId);
        int type = user.getType();
        book.setAuthor(user.getUsername());
        if(type == UserType.STUDENT || type == UserType.STUDENT_FROM_UOFT){
            book.setStatus(BookStatus.UNDER_REVIEW_STATUS);
        }else{
            book.setStatus(BookStatus.PUBLIC_STATUS);
        }
        R re = bookFeignService.add(book, sectionIds);
        if(!re.isSuccess()){
            return false;
        }
        long bookId = Long.parseLong((String)re.getData().get("bookId"));
        CompletableFuture<Void> sendUpload = CompletableFuture.runAsync(() -> {
            thirdPartyFeignService.send(user.getEmail(), MessageContent.NEW_DOCUMENT_UPLOAD_TITLE,
                    MessageContent.NEW_DOCUMENT_UPLOAD_CONTENT);
        }, executor);
        if(book.getStatus() == BookStatus.PUBLIC_STATUS){
            return true;
        }
        Tag tag = tagService.getById(book.getTagId());
        User reviewer = getById(tag.getCreateBy());
        MessageVo messageVo = new MessageVo();
        messageVo.setMessageType(MessageVo.MessageType.REVIEW_NOTIFICATION);
        messageVo.setBookId(bookId);
        messageVo.setBookTitle(book.getTitle());
        messageVo.setContent(book.getSource());
        messageVo.setSenderId(user.getId());
        messageVo.setSenderNickname(user.getNickname());
        messageVo.setSenderAvatar(user.getAvatar());
        messageVo.setReceiverId(reviewer.getId());
        messageVo.setReceiverNickname(reviewer.getNickname());
        messageVo.setContent(MessageContent.NEW_DOCUMENT_REVIEW_CONTENT+user.getNickname()+".");
        messageVo.setCreateTime(new Date(System.currentTimeMillis()));
        String hashKey = String.valueOf(redisTemplate.opsForHash()
                .size(RedisCommon.USER_UNREAD_MESSAGE_PREFIX + reviewer.getId()));
        messageVo.setHashKey(hashKey);
        //msg for reviewer
        redisTemplate.opsForHash().put(RedisCommon.USER_UNREAD_MESSAGE_PREFIX + reviewer.getId(),
                hashKey,
                messageVo);
        sendUpload.thenRunAsync(()->{
            thirdPartyFeignService.send(reviewer.getEmail(),MessageContent.NEW_DOCUMENT_REVIEW_TITLE,
                    MessageContent.NEW_DOCUMENT_REVIEW_CONTENT+user.getNickname()+".");
        }, executor);
        //msg for submitter
        messageVo.setMessageType(MessageVo.MessageType.UPLOAD_NOTIFICATION);
        messageVo.setContent(MessageContent.NEW_DOCUMENT_UPLOAD_CONTENT);
        messageVo.setSenderId(reviewer.getId());
        messageVo.setSenderAvatar(reviewer.getAvatar());
        messageVo.setReceiverId(user.getId());
        messageVo.setReceiverNickname(user.getNickname());
        redisTemplate.opsForHash().put(RedisCommon.USER_UNREAD_MESSAGE_PREFIX + user.getId(),
                hashKey,
                messageVo);
        return true;
    }

    @Override
    public Book canView(long id, long bookId) {
        User user = getById(id);
        R r = bookFeignService.getBook(bookId);
        Book book = JSON.parseObject(JSON.toJSONString(r.getData().get("book")), Book.class);
        if(id == tagService.getById(book.getTagId()).getCreateBy()){
            return book;
        }
        return book.getAuthor().equals(user.getUsername()) ? book : null;
    }

    @Override
    public boolean reviewResult(boolean isApproved, UserTo reviewer, long bookId) {
        Book book = canView(reviewer.getId(), bookId);
        if(book == null){
            return false;
        }
        User author = getOne(new QueryWrapper<User>().eq("username", book.getAuthor()));
        MessageVo messageVo = new MessageVo();
        messageVo.setReceiverId(author.getId());
        messageVo.setReceiverNickname(author.getNickname());
        messageVo.setSenderId(reviewer.getId());
        messageVo.setSenderNickname(reviewer.getNickname());
        messageVo.setSenderAvatar(reviewer.getAvatar());
        messageVo.setMessageType(MessageVo.MessageType.UPLOAD_NOTIFICATION);
        messageVo.setCreateTime(new Date(System.currentTimeMillis()));
        messageVo.setBookTitle(book.getTitle());
        messageVo.setBookId(bookId);
        if(isApproved){
            book.setStatus(BookStatus.PUBLIC_STATUS);
            bookFeignService.update(book);
            messageVo.setContent(MessageContent.DOCUMENT_STATUS_APPROVE_CONTENT);
            CompletableFuture.runAsync(()->{
                thirdPartyFeignService.send(author.getEmail(),
                        MessageContent.DOCUMENT_STATUS_CHANGE_TITLE,
                        MessageContent.DOCUMENT_STATUS_APPROVE_CONTENT);
            }, executor);
        }else{
            CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
                thirdPartyFeignService.delete(book.getSourceKeyname());
            }, executor);
            CompletableFuture<Void> future2 = null;
            if(!StringUtils.isBlank(book.getCoverKeyname())){
                future2 = CompletableFuture.runAsync(() -> {
                    thirdPartyFeignService.delete(book.getCoverKeyname());
                }, executor);
            }
            if(future2 != null){
                CompletableFuture.allOf(future1, future2);
            }else{
                CompletableFuture.allOf(future1);
            }
            book.setStatus(BookStatus.DELETED_STATUS);
            book.setCover("");
            book.setCoverKeyname("");
            book.setSource("");
            book.setSourceKeyname("");
            CompletableFuture.runAsync(()->{
                bookFeignService.update(book);
            }, executor);
            messageVo.setContent(MessageContent.DOCUMENT_STATUS_DENY_CONTENT);
            CompletableFuture.runAsync(()->{
                thirdPartyFeignService.send(author.getEmail(),
                        MessageContent.DOCUMENT_STATUS_CHANGE_TITLE,
                        MessageContent.DOCUMENT_STATUS_DENY_CONTENT);
            }, executor);
        }
        redisTemplate.opsForHash().put(RedisCommon.USER_UNREAD_MESSAGE_PREFIX + author.getId(),
                redisTemplate.opsForHash().size(RedisCommon.USER_UNREAD_MESSAGE_PREFIX + reviewer.getId()),
                messageVo);
        return true;
    }

    @Override
    public List<Book> getUploadHistory(long id) {
        return null;
    }

    @Override
    public User getPublicProfile(long userId) {
        User user = getById(userId);
        user.setPassword("");
        return user;
    }

    @Override
    public R sendCode(String email) {
        String code = UUID.randomUUID().toString().substring(0, 5);
        R res = thirdPartyFeignService.send(email, "verification code from EBook: ", code);
        if(res.getCode() != ResultCode.SUCCESS){
            return res;
        }
        res.getData().put(CookieUtil.VERIFY_CODE_KEY, MD5.encrypt(code));
        return res;
    }

}
