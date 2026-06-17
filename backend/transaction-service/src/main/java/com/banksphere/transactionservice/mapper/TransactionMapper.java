package com.banksphere.transactionservice.mapper;

import com.banksphere.transactionservice.dto.TransactionResponseDto;
import com.banksphere.transactionservice.entity.Transaction;

public class TransactionMapper {

    private TransactionMapper() {
    }

    public static TransactionResponseDto
    mapToTransactionResponseDto(
            Transaction transaction) {

        return TransactionResponseDto.builder()

                .transactionReference(
                        transaction.getTransactionReference()
                )

                .fromAccount(
                        transaction.getFromAccount()
                )

                .toAccount(
                        transaction.getToAccount()
                )

                .amount(
                        transaction.getAmount()
                )

                .transactionType(
                        transaction.getTransactionType()
                )

                .transactionStatus(
                        transaction.getTransactionStatus()
                )

                .transactionDate(
                        transaction.getTransactionDate()
                )

                .remarks(
                        transaction.getRemarks()
                )

                .build();
    }
}