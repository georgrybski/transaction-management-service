package com.transactionmanagementservice.mapper;


import com.transactionmanagementservice.dto.transaction.creation.TransactionCreationDTO;
import com.transactionmanagementservice.mapper.config.MappingConfig;
import com.transactionmanagementservice.model.Transaction;
import com.transactionmanagementservice.model.TransactionItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(config = MappingConfig.class)
public interface TransactionMapper {
//    TransactionCreationDTO toTransactionDTO(Transaction transaction);
    Transaction toTransaction(TransactionCreationDTO transactionCreationDTO);

//    TransactionItemCreationDTO toTransactionItemDTO(TransactionItem transactionItem);
    TransactionItem toTransactionItem(TransactionCreationDTO transactionItemDTO);
}