package com.ebook.user;

import com.ebook.common.common.RedisCommon;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @Author: Cliffe
 * @Date: 2022-09-13 2:25 下午
 */
@SpringBootApplication
@MapperScan({"com.ebook.user.dao"})
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.ebook.user.feign")
@Import(value = {com.ebook.common.config.CorsConfig.class,
        RedisCommon.class})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
