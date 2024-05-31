package com.ebook.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Cliffe
 * @Date: 2021-09-13 8:54 上午
 */
@ConfigurationProperties(prefix = "ebook.thread.pool")
@Component
@Data
public class ThreadPoolConfigurationProperties {
    private Integer coreSize;
    private Integer maxSize;
    private Integer keepAliveTime;

}
