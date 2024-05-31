package com.ebook.book.service.impl;

import com.ebook.book.entity.vo.SectionVo;
import com.ebook.book.service.IBookSectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Cliffe
 * @Date: 2022-11-28 10:35 上午
 */
@SpringBootTest
class BookSectionServiceImplTest {

    @Autowired
    private IBookSectionService bookSectionService;

    @Test
    void getTopSectionVo() {
        for (SectionVo sectionVo : bookSectionService.getTopSectionVo(1)) {
            System.out.println(sectionVo.getSectionName());
        }
    }

    @Test
    void getBookIdBySectionId() {
        for (Long id : bookSectionService.getBookIdBySectionId(200)) {
            System.out.println(id);
        }
    }

    @Test
    void remove() {
        bookSectionService.remove(200);
    }
}