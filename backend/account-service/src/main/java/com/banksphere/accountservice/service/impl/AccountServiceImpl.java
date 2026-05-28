package com.banksphere.accountservice.service.impl;

import com.banksphere.accountservice.dto.AccountResponseDto;
import com.banksphere.accountservice.dto.CreateAccountRequestDto;
import com.banksphere.accountservice.entity.Account;
import com.banksphere.accountservice.enums.AccountStatus;
import com.banksphere.accountservice.repository.AccountRepository;
import com.banksphere.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountResponseDto createAccount(CreateAccountRequestDto requestDto) {

        Account account = Account.builder()
                .accountNumber(generateAccountNumber())
                .accountHolderName(requestDto.getAccountHolderName())
                .balance(requestDto.getInitialBalance())
                .accountType(requestDto.getAccountType())
                .status(AccountStatus.ACTIVE)
                .build();

        Account savedAccount = accountRepository.save(account);

        return mapToResponse(savedAccount);
    }

    @Override
    public AccountResponseDto getAccountByAccountNumber(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new RuntimeException("Account not found"));

        return mapToResponse(account);
    }

    private String generateAccountNumber() {

        return "ACC" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

    private AccountResponseDto mapToResponse(Account account) {

        return AccountResponseDto.builder()
                .accountNumber(account.getAccountNumber())
                .accountHolderName(account.getAccountHolderName())
                .balance(account.getBalance())
                .accountType(account.getAccountType())
                .accountStatus(account.getStatus())
                .build();
    }
}