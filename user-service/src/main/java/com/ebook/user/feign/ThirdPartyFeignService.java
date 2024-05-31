package com.ebook.user.feign;

import com.ebook.common.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Cliffe
 * @Date: 2022-09-21 10:34 上午
 */
@FeignClient(value = "thirdparty-service")
@Component
public interface ThirdPartyFeignService {

    @RequestMapping(value = "/rest/thirdparty/mail/send")
    R send(@RequestParam("mail") String to, @RequestParam("title")String title,
           @RequestParam("content")String content);

    @PostMapping(value = "/rest/thirdparty/s3/upload",
            headers = "content-type=" + MediaType.MULTIPART_FORM_DATA_VALUE)
    R upload(@RequestPart("file") MultipartFile file,
                    @RequestParam("folderName") String folderName);

    @PostMapping( "/rest/thirdparty/s3/delete")
    R delete(@RequestParam("keyname") String keyname);
}
