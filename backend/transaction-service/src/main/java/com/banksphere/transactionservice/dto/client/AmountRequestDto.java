package com.banksphere.transactionservice.dto.client;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmountRequestDto {

    private BigDecimal amount;
}