package com.banksphere.transactionservice.client;

import com.banksphere.transactionservice.dto.client.AccountResponseDto;
import com.banksphere.transactionservice.dto.client.AmountRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountClient {

    @GetMapping("/accounts/{accountNumber}")
    AccountResponseDto getAccount(
            @PathVariable String accountNumber
    );

    @PutMapping("/accounts/{accountNumber}/debit")
    AccountResponseDto debitAmount(
            @PathVariable String accountNumber,
            @RequestBody AmountRequestDto requestDto
    );

    @PutMapping("/accounts/{accountNumber}/credit")
    AccountResponseDto creditAmount(
            @PathVariable String accountNumber,
            @RequestBody AmountRequestDto requestDto
    );
}