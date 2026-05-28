package com.banksphere.accountservice.dto;

import com.banksphere.accountservice.enums.AccountType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountRequestDto {

    @NotBlank(message = "Account holder name is required")
    private String accountHolderName;

    @NotNull(message = "Initial balance is required")
    @DecimalMin(value = "0.0", inclusive = true,
            message = "Balance must be greater than or equal to 0")
    private BigDecimal initialBalance;

    @NotNull(message = "Account type is required")
    private AccountType accountType;
}