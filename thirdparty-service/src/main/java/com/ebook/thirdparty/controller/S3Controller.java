package com.ebook.thirdparty.controller;

import com.ebook.common.common.R;
import com.ebook.common.common.ResultCode;
import com.ebook.common.vo.AmazonFileVo;
import com.ebook.thirdparty.service.IAWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Cliffe
 * @Date: 2022-10-06 5:47 下午
 */
@RestController
@RequestMapping("/rest/thirdparty/s3")
public class S3Controller {

    @Autowired
    IAWSService awsService;

    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R upload(@RequestPart("file") MultipartFile file,
                    @RequestParam("folderName") String folderName){
        AmazonFileVo amazonFileModel;
        try{
            amazonFileModel= awsService.upload(file, folderName);
        }catch (Exception e){
            return R.error(ResultCode.THIRD_PARTY_SERVICE_EXCEPTION).message(e.getMessage());
        }
        return R.ok().data("fileModel", amazonFileModel);
    }

    @PostMapping( "delete")
    public R delete(@RequestParam("keyname") String keyname){
        return awsService.deleteFile(keyname) ? R.ok() : R.error();
    }
}
