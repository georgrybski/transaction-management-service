package com.transactionmanagementservice.dto.transaction.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transactionmanagementservice.dto.address.AddressDTO;
import com.transactionmanagementservice.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponseDTO {
    private Long id;
    private UserDTO user;
    private AddressDTO address;
    private BigDecimal totalPrice;
    private String status;
    private String paymentMethod;
    private String paymentStatus;
    private List<TransactionItemResponseDTO> transactionItems;
}
