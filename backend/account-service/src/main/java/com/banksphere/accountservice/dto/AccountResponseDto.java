package com.banksphere.accountservice.dto;

import com.banksphere.accountservice.enums.AccountStatus;
import com.banksphere.accountservice.enums.AccountType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountResponseDto {

    private String accountNumber;

    private String accountHolderName;

    private BigDecimal balance;

    private AccountType accountType;

    private AccountStatus accountStatus;
}