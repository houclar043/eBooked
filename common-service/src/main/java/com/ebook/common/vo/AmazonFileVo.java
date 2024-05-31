package com.ebook.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Cliffe
 * @Date: 2022-10-06 5:51 下午
 * @Description aws s3 cloud storage view object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmazonFileVo implements Serializable {

    private static final long serialVersionUID=1L;

    private long fileSize;

    private String fileName;

    private String url;

    private String keyname;

    private String fileType;
}
