package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction saveTransaction(Transaction transaction){
        transaction.setApprovalCode(UUID.randomUUID().toString());
        transaction.setDate(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}
