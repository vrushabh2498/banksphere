package com.banksphere.accountservice.controller;

import com.banksphere.accountservice.dto.AccountResponseDto;
import com.banksphere.accountservice.dto.AmountRequestDto;
import com.banksphere.accountservice.dto.CreateAccountRequestDto;
import com.banksphere.accountservice.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
       //add
	   
    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDto createAccount(
            @Valid @RequestBody CreateAccountRequestDto requestDto) {

        return accountService.createAccount(requestDto);
    }

    @GetMapping("/{accountNumber}")
    public AccountResponseDto getAccountByAccountNumber(
            @PathVariable String accountNumber) {

        return accountService.getAccountByAccountNumber(accountNumber);
    }
    
    @PutMapping("/{accountNumber}/credit")
    public ResponseEntity<AccountResponseDto>
    creditAmount(
            @PathVariable String accountNumber,
            @Valid @RequestBody AmountRequestDto requestDto) {

        return ResponseEntity.ok(
                accountService.creditAmount(
                        accountNumber,
                        requestDto
                )
        );
    }

    @PutMapping("/{accountNumber}/debit")
    public ResponseEntity<AccountResponseDto>
    debitAmount(
            @PathVariable String accountNumber,
            @Valid @RequestBody AmountRequestDto requestDto) {

        return ResponseEntity.ok(
                accountService.debitAmount(
                        accountNumber,
                        requestDto
                )
        );
    }
}