package com.transactionmanagementservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ApiConfiguration {

    @Value("${address-api.url}")
    private String addressApiUrl;

    @Value("${book-api.url}")
    private String bookApiUrl;

    @Value("${user-api.url}")
    private String userApiUrl;

    @Bean
    public String getAddressApiUrl() {
        return addressApiUrl;
    }

    @Bean
    public String getBookApiUrl() {
        return bookApiUrl;
    }

    @Bean
    public String getUserApiUrl() {
        return userApiUrl;
    }
}