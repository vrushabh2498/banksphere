package com.banksphere.transactionservice.repository;

import com.banksphere.transactionservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByTransactionReference(
            String transactionReference
    );
    
    List<Transaction> findByFromAccountOrToAccount(
            String fromAccount,
            String toAccount
    );
}