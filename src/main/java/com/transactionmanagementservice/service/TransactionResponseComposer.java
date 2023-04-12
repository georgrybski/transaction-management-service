package com.transactionmanagementservice.service;

import com.transactionmanagementservice.clients.AddressMicrosserviceClient;
import com.transactionmanagementservice.clients.BookMicrosserviceClient;
import com.transactionmanagementservice.clients.UserMicrosserviceClient;
import com.transactionmanagementservice.dto.book.BookDTO;import com.transactionmanagementservice.dto.transaction.response.TransactionItemResponseDTO;
import com.transactionmanagementservice.dto.transaction.response.TransactionResponseDTO;
import com.transactionmanagementservice.model.Transaction;
import com.transactionmanagementservice.model.TransactionItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class TransactionResponseComposer {
    private AddressMicrosserviceClient addressMicrosserviceClient;
    private BookMicrosserviceClient bookMicrosserviceClient;
    private UserMicrosserviceClient userMicrosserviceClient;

    public TransactionResponseDTO compose(Transaction transaction) {
        return TransactionResponseDTO.builder()
                .id(transaction.getId())
                .user(userMicrosserviceClient.fetchById(transaction.getUserId()))
                .address(addressMicrosserviceClient.fetchById(transaction.getAddressId()))
                .totalPrice(transaction.getTotalPrice())
                .status(transaction.getStatus())
                .paymentMethod(transaction.getPaymentMethod())
                .paymentStatus(transaction.getPaymentStatus())
                .transactionItems(composeItems(transaction.getTransactionItems()))
                .build();
    }

    private List<TransactionItemResponseDTO> composeItems(List<TransactionItem> transactionItems) {
        List<TransactionItemResponseDTO> transactionItemResponseDTOS = new ArrayList<>();
        transactionItems.forEach(transactionItem -> {
            var transactionItemResponseDTO = new TransactionItemResponseDTO();
            BookDTO bookDTO = bookMicrosserviceClient.fetchById(transactionItem.getBookId());
            transactionItemResponseDTO.setBook(bookDTO);
            transactionItemResponseDTO.setQuantity(transactionItem.getQuantity());
            transactionItemResponseDTO.setUnitPrice(transactionItem.getUnitPrice());
            transactionItemResponseDTO.setDiscount(transactionItem.getDiscount());
            transactionItemResponseDTO.setTotalPrice(transactionItem.getTotalPrice());
            transactionItemResponseDTOS.add(transactionItemResponseDTO);

        });
        return transactionItemResponseDTOS;
    }
}
