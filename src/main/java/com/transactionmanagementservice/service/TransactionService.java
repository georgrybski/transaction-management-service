package com.transactionmanagementservice.service;

import com.transactionmanagementservice.dto.transaction.creation.TransactionCreationDTO;
import com.transactionmanagementservice.dto.transaction.creation.TransactionItemCreationDTO;
import com.transactionmanagementservice.dto.transaction.response.TransactionResponseDTO;
import com.transactionmanagementservice.mapper.TransactionMapper;
import com.transactionmanagementservice.model.Transaction;
import com.transactionmanagementservice.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;
    private TransactionResponseComposer responseComposer;

    public TransactionResponseDTO fetchTransactionById(Long id) {
        return responseComposer.compose(transactionRepository.findById(id).orElseThrow());
    }

    public Transaction createTransaction(TransactionCreationDTO transactionCreationDTO) {
        return transactionRepository.save(transactionMapper.toTransaction(transactionCreationDTO));
    }

    public Transaction updatePaymentStatus(Long id, String status) {
        Transaction transaction = findByIdOrThrow(id);
        transaction.setPaymentStatus(status);
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransactionStatus(Long id, String status) {
        Transaction transaction = findByIdOrThrow(id);
        transaction.setStatus(status);
        return transactionRepository.save(transaction);
    }

    private Transaction findByIdOrThrow(Long id) {
        return transactionRepository.findById(id).orElseThrow();
    }

    public List<TransactionResponseDTO> fetchAllTransactions() {
        return transactionRepository.findAll().stream()
                                              .map(responseComposer::compose)
                                              .toList();
    }

    public TransactionCreationDTO getExampleTransactionCreationDTO() {
        TransactionCreationDTO transactionCreationDTO = new TransactionCreationDTO();
        List<TransactionItemCreationDTO> transactionItemCreationDTOS = new ArrayList<>();
        TransactionItemCreationDTO transactionItemCreationDTO = new TransactionItemCreationDTO();
        transactionItemCreationDTO.setBookId(1L);
        transactionItemCreationDTO.setQuantity(2);
        transactionItemCreationDTO.setUnitPrice(BigDecimal.valueOf(100.0));
        transactionItemCreationDTO.setTotalPrice(BigDecimal.valueOf(200.0));
        transactionItemCreationDTO.setDiscount(BigDecimal.valueOf(0.0));
        transactionItemCreationDTOS.add(transactionItemCreationDTO);

        transactionItemCreationDTO = new TransactionItemCreationDTO();
        transactionItemCreationDTO.setBookId(2L);
        transactionItemCreationDTO.setQuantity(1);
        transactionItemCreationDTO.setUnitPrice(BigDecimal.valueOf(50.0));
        transactionItemCreationDTO.setTotalPrice(BigDecimal.valueOf(50.0));
        transactionItemCreationDTO.setDiscount(BigDecimal.valueOf(0.0));
        transactionItemCreationDTOS.add(transactionItemCreationDTO);

        transactionCreationDTO.setTransactionItems(transactionItemCreationDTOS);
        transactionCreationDTO.setUserId(1L);
        transactionCreationDTO.setAddressId(1L);
        transactionCreationDTO.setPaymentMethod("CASH");
        transactionCreationDTO.setPaymentStatus("PAID");
        transactionCreationDTO.setStatus("COMPLETED");
        transactionCreationDTO.setTotalPrice(BigDecimal.valueOf(250.0));
        return transactionCreationDTO;
    }
}
