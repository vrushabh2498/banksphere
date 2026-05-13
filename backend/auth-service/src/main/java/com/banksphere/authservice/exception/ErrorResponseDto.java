package com.banksphere.authservice.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
	
	private LocalDateTime timestamp;

    private int status;

    private String message;

}
