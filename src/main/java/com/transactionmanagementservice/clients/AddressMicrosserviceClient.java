package com.transactionmanagementservice.clients;

import com.transactionmanagementservice.config.ApiConfiguration;
import com.transactionmanagementservice.dto.address.AddressDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class AddressMicrosserviceClient extends GenericMicrosserviceClient<AddressDTO, Long> {
    public AddressMicrosserviceClient(ApiConfiguration apiConfiguration) {
        super(apiConfiguration);
    }

    @PostConstruct
    public void init() {
        setRestTemplateBuilder(new RestTemplateBuilder());
        setApiUrl(getApiConfiguration().getAddressApiUrl());
        setResponseClass(AddressDTO.class);
    }
}