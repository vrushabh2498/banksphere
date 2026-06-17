package com.banksphere.transactionservice.service;

import java.util.List;

import com.banksphere.transactionservice.dto.TransactionResponseDto;
import com.banksphere.transactionservice.dto.TransferRequestDto;

public interface TransactionService {

	TransactionResponseDto transferMoney(TransferRequestDto requestDto);

	TransactionResponseDto getTransactionByReference(String transactionReference);

	List<TransactionResponseDto> getAllTransactions();

	List<TransactionResponseDto>getTransactionsByAccount(String accountNumber);
}