package com.ebook.book.feign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ebook.common.common.R;
import com.ebook.common.vo.QueryVo;
import com.ebook.common.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Cliffe
 * @Date: 2022-10-08 2:04 下午
 */
@SpringBootTest
class UserFeignServiceTest {

    @Autowired
    private UserFeignService userFeignService;

    @Test
    void getPagedUser() {
        QueryVo queryVo = new QueryVo();
        queryVo.setKeyword("j");
        R res = userFeignService.getPagedUser(queryVo);
        Page<UserVo> userVoPage = JSON.parseObject(JSON.toJSONString(res.getData().get("userVoPage"))
                , new TypeReference<Page<UserVo>>() {});
        for (UserVo record : userVoPage.getRecords()) {
            System.out.println(record.getUsername());
        }
    }
}