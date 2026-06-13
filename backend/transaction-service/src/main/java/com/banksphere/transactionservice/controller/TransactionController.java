package com.banksphere.transactionservice.controller;

import com.banksphere.transactionservice.dto.TransactionResponseDto;
import com.banksphere.transactionservice.dto.TransferRequestDto;
import com.banksphere.transactionservice.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/transactions")

@RequiredArgsConstructor

public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transfer")

    public ResponseEntity<TransactionResponseDto>
    transferMoney(

            @Valid
            @RequestBody
            TransferRequestDto requestDto) {

        TransactionResponseDto responseDto =
                transactionService
                        .transferMoney(requestDto);

        return new ResponseEntity<>(
                responseDto,
                HttpStatus.CREATED
        );
    }
}