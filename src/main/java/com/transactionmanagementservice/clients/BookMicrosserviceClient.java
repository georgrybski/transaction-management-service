package com.transactionmanagementservice.clients;

import com.transactionmanagementservice.config.ApiConfiguration;
import com.transactionmanagementservice.dto.book.BookDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookMicrosserviceClient extends GenericMicrosserviceClient<BookDTO, Long> {
    public BookMicrosserviceClient(ApiConfiguration apiConfiguration) {
        super(apiConfiguration);
    }

    @PostConstruct
    public void init() {
        setRestTemplateBuilder(new RestTemplateBuilder());
        setApiUrl(getApiConfiguration().getBookApiUrl());
        setResponseClass(BookDTO.class);
    }
}
