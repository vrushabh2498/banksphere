package com.banksphere.accountservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDto {

    private String message;

    private int status;

    private LocalDateTime timestamp;
}