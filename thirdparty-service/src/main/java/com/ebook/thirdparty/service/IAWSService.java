package com.ebook.thirdparty.service;

import com.ebook.common.vo.AmazonFileVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Cliffe
 * @Date: 2022-10-06 5:53 下午
 */
public interface IAWSService {

    /**
     * @Description file upload
     * @Param [file, uid]
     * "fileModel": {
     *             "fileSize": 7551,
     *             "fileName": "default-book-cover.png0c30fec3fc004fb38d903b67a6c48115",
     *             "url": "https://csc207-ebook-storage.s3.ca-central-1.amazonaws.com/test/2022-10-19/default-book-cover.png0c30fec3fc004fb38d903b67a6c48115",
     *             "filePath": "csc207-ebook-storage/test/2022-10-19",
     *             "fileType": "image/png"
     *         }
     */
    AmazonFileVo upload(MultipartFile file, String FolderName);

    /**
     * physically delete action
     * @param keyname eg.test/2022-10-19/default-book-cover.png0c30fec3fc004fb38d903b67a6c48115
     *
     * @return
     */
    boolean deleteFile(String keyname);

}
