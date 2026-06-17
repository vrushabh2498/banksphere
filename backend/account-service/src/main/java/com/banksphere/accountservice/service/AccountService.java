package com.banksphere.accountservice.service;

import com.banksphere.accountservice.dto.AccountResponseDto;
import com.banksphere.accountservice.dto.AmountRequestDto;
import com.banksphere.accountservice.dto.CreateAccountRequestDto;

public interface AccountService {

    AccountResponseDto createAccount(CreateAccountRequestDto requestDto);

    AccountResponseDto getAccountByAccountNumber(String accountNumber);
    
    AccountResponseDto creditAmount(String accountNumber, AmountRequestDto requestDto );

    AccountResponseDto debitAmount( String accountNumber,  AmountRequestDto requestDto );
}