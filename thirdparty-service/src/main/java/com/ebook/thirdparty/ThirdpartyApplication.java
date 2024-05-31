package com.ebook.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ThirdpartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdpartyApplication.class, args);
    }

}
