package com.transactionmanagementservice.dto.transaction.response;

import com.transactionmanagementservice.dto.book.BookDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionItemResponseDTO {
    private BookDTO book;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    private BigDecimal totalPrice;
}
