package com.banksphere.transactionservice.service;

import com.banksphere.transactionservice.dto.TransactionResponseDto;
import com.banksphere.transactionservice.dto.TransferRequestDto;

public interface TransactionService {

    TransactionResponseDto transferMoney(
            TransferRequestDto requestDto
    );
}