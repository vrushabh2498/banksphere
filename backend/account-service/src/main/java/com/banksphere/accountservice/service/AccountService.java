package com.banksphere.accountservice.service;

import com.banksphere.accountservice.dto.AccountResponseDto;
import com.banksphere.accountservice.dto.CreateAccountRequestDto;

public interface AccountService {

    AccountResponseDto createAccount(CreateAccountRequestDto requestDto);

    AccountResponseDto getAccountByAccountNumber(String accountNumber);
}