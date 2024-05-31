package com.ebook.user.feign;

import com.ebook.common.common.R;
import com.ebook.common.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Cliffe
 * @Date: 2022-10-22 4:57 下午
 */
@FeignClient(value = "book-service")
public interface BookFeignService {

    /**
     * if redis has no unread message, get recent reply comments,
     * limit ${count}
     */
    @GetMapping("rest/book/comment/recentComment")
    R getRecentComment(@RequestParam("userId") Long userId, @RequestParam("count") int count);

    @RequestMapping("/rest/book/book/add")
    R add(@RequestBody Book book, @RequestParam("sectionIds") List<Long> sectionIds);

    @GetMapping("/rest/book/book/getSections")
    R getSections();

    @RequestMapping("/rest/book/book/getBook/{bookId}")
    R getBook(@PathVariable("bookId") long bookId);

    @RequestMapping("/rest/book/book/update")
    R update(@RequestBody Book book);

    @RequestMapping("/rest/book/book/getBook/author")
    R getBookByAuthor(@RequestParam("author")String author);
}
