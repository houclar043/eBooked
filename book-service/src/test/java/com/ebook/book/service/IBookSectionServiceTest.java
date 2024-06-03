package com.ebook.book.service;

import com.ebook.book.entity.vo.SectionVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Cliffe
 * @Date: 2022-10-05 10:17 上午
 */
@SpringBootTest
class IBookSectionServiceTest {

    @Autowired
    private IBookSectionService bookSectionService;

    @Test
    void getTopSectionVo() {
        for (SectionVo sectionVo : bookSectionService.getTopSectionVo(2)) {
            System.out.println(sectionVo.toString());
        }
    }
}