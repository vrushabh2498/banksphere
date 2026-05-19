package com.banksphere.authservice.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponseDto> handleRuntimeException(RuntimeException ex){
		
		ErrorResponseDto errorResponse = new ErrorResponseDto(
				 LocalDateTime.now(),
                 HttpStatus.UNAUTHORIZED.value(),
                 ex.getMessage()
		);
		
		 return new ResponseEntity<>(
	                errorResponse,
	                HttpStatus.UNAUTHORIZED
	        );
	}

}
