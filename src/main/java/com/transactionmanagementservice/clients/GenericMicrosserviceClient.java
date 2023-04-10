package com.transactionmanagementservice.clients;

import com.transactionmanagementservice.config.ApiConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class GenericMicrosserviceClient<T, U> {
    private final ApiConfiguration apiConfiguration;
    private RestTemplateBuilder restTemplateBuilder;
    private String apiUrl;
    private Class<T> responseClass;
    public T fetchById(U id) {
        RestTemplate restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(10))
                .setReadTimeout(Duration.ofSeconds(10))
                .build();

        return restTemplate.getForObject(apiUrl + "/" + id, responseClass);
    }
}
