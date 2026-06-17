package com.banksphere.transactionservice.dto.client;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDto {

    private String accountNumber;

    private String accountHolderName;

    private BigDecimal balance;

    private String accountType;

    private String accountStatus;
}