package com.banksphere.transactionservice.service.impl;

import com.banksphere.transactionservice.client.AccountClient;
import com.banksphere.transactionservice.dto.TransactionResponseDto;
import com.banksphere.transactionservice.dto.TransferRequestDto;
import com.banksphere.transactionservice.dto.client.AccountResponseDto;
import com.banksphere.transactionservice.dto.client.AmountRequestDto;
import com.banksphere.transactionservice.entity.Transaction;
import com.banksphere.transactionservice.enums.TransactionStatus;
import com.banksphere.transactionservice.enums.TransactionType;
import com.banksphere.transactionservice.mapper.TransactionMapper;
import com.banksphere.transactionservice.repository.TransactionRepository;
import com.banksphere.transactionservice.service.TransactionService;
import com.banksphere.transactionservice.util.TransactionReferenceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class TransactionServiceImpl
        implements TransactionService {

    private final TransactionRepository
            transactionRepository;
    
    private final AccountClient accountClient;

    @Override
    @Transactional
    public TransactionResponseDto transferMoney(
            TransferRequestDto requestDto) {

      
        AccountResponseDto senderAccount =
                accountClient.getAccount(
                        requestDto.getFromAccount()
                );

       
        AccountResponseDto receiverAccount =
                accountClient.getAccount(
                        requestDto.getToAccount()
                );

     
        if (senderAccount.getBalance()
                .compareTo(requestDto.getAmount()) < 0) {

            throw new IllegalArgumentException(
                    "Insufficient balance"
            );
        }

       
        AmountRequestDto amountRequest =
                AmountRequestDto.builder()
                        .amount(requestDto.getAmount())
                        .build();

        accountClient.debitAmount(
                requestDto.getFromAccount(),
                amountRequest
        );

       
        accountClient.creditAmount(
                requestDto.getToAccount(),
                amountRequest
        );

       
        Transaction transaction =
                Transaction.builder()
                        .transactionReference(
                                TransactionReferenceUtil
                                        .generateTransactionReference()
                        )
                        .fromAccount(
                                requestDto.getFromAccount()
                        )
                        .toAccount(
                                requestDto.getToAccount()
                        )
                        .amount(
                                requestDto.getAmount()
                        )
                        .transactionType(
                                TransactionType.TRANSFER
                        )
                        .transactionStatus(
                                TransactionStatus.SUCCESS
                        )
                        .transactionDate(
                                LocalDateTime.now()
                        )
                        .remarks(
                                requestDto.getRemarks()
                        )
                        .build();

        Transaction savedTransaction =
                transactionRepository.save(
                        transaction
                );

        return TransactionMapper
                .mapToTransactionResponseDto(
                        savedTransaction
                );
    }}