package com.transactionmanagementservice.clients;

import com.transactionmanagementservice.config.ApiConfiguration;
import com.transactionmanagementservice.dto.user.UserDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserMicrosserviceClient extends GenericMicrosserviceClient<UserDTO, Long> {
    public UserMicrosserviceClient(ApiConfiguration apiConfiguration) {
        super(apiConfiguration);
    }

    @PostConstruct
    public void init() {
        setRestTemplateBuilder(new RestTemplateBuilder());
        setApiUrl(getApiConfiguration().getUserApiUrl());
        setResponseClass(UserDTO.class);
    }
}

