package com.ebook.thirdparty.service.impl;

import com.amazonaws.*;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.ebook.common.vo.AmazonFileVo;
import com.ebook.thirdparty.service.IAWSService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: Cliffe
 * @Date: 2022-10-06 5:53 下午
 */
@Service
public class AWSServiceImpl implements IAWSService {
    AmazonS3 s3 = null;

    @Value("${s3.accessKeyId}")
    private String accessKeyId;

    @Value("${s3.accessKeySecret}")
    private String accessKeySecret;

    @Value("${s3.bucketName}")
    private String bucketName;

    @Value("${s3.region}")
    private String regionName;

    AmazonS3 s3Client;


    @Override
    public AmazonFileVo upload(MultipartFile file, String folderName) {
        String dateDir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String tempBucketName = bucketName + "/" + folderName +  "/" + dateDir;
        File tempFile = MultipartFileToFile(file);
        String fileName = UUID.randomUUID().toString().replaceAll("-", "")
                + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(tempBucketName, fileName, tempFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketName, fileName);
        URL url = s3Client.generatePresignedUrl(urlRequest);
        String urlPath = "https://" + bucketName + ".s3." + regionName + ".amazonaws.com/" +
                folderName +  "/" + dateDir + url.getPath();
        return new AmazonFileVo(file.getSize(), fileName,
                urlPath, folderName +  "/" + dateDir + "/" + fileName, file.getContentType());
    }

    @Override
    public boolean deleteFile(String keyname) {
        try {
            s3Client.deleteObject(bucketName, keyname);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }


    @PostConstruct
    public void init() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
        s3Client = AmazonS3Client.builder()
                .withRegion(regionName)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    private static File MultipartFileToFile(MultipartFile multiFile) {
        String fileName = multiFile.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        try {
            File file = File.createTempFile(fileName, prefix);
            multiFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
