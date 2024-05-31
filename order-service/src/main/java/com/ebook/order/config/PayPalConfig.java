package com.ebook.order.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Cliffe
 * @Date: 2022-10-20 5:13 下午
 */
@Configuration
public class PayPalConfig {
    @Value("${paypal.client.id}")
    public String PAYPAL_CLIENT_ID;

    @Value("${paypal.client.secret}")
    public String PAYPAL_CLIENT_SECRET;

    @Value("${paypal.client.mode}")
    public String PAYPAL_MODE;

    public static final String SUCCESS_URL = "success";
    public static final String CANCEL_URL = "cancel";

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        Map<String, String> map = new HashMap<>();
        map.put("mode", PAYPAL_MODE);
        APIContext context = new APIContext(new OAuthTokenCredential(
                PAYPAL_CLIENT_ID, PAYPAL_CLIENT_SECRET, map).getAccessToken());
        context.setConfigurationMap(map);
        context.setMaskRequestId(true);
        return context;
    }

}
