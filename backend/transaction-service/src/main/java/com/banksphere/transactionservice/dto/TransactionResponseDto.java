package com.banksphere.transactionservice.dto;

import com.banksphere.transactionservice.enums.TransactionStatus;
import com.banksphere.transactionservice.enums.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TransactionResponseDto {

    private String transactionReference;

    private String fromAccount;

    private String toAccount;

    private BigDecimal amount;

    private TransactionType transactionType;

    private TransactionStatus transactionStatus;

    private LocalDateTime transactionDate;

    private String remarks;
}