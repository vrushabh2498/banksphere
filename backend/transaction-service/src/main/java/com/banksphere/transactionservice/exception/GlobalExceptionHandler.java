package com.banksphere.transactionservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            InsufficientBalanceException.class
    )
    public ResponseEntity<ErrorResponse>
    handleInsufficientBalanceException(
            InsufficientBalanceException ex) {

        ErrorResponse response =
                ErrorResponse.builder()
                        .message(ex.getMessage())
                        .status(
                                HttpStatus.BAD_REQUEST.value()
                        )
                        .timestamp(
                                LocalDateTime.now()
                        )
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(
            TransactionNotFoundException.class
    )
    public ResponseEntity<ErrorResponse>
    handleTransactionNotFoundException(
            TransactionNotFoundException ex) {

        ErrorResponse response =
                ErrorResponse.builder()
                        .message(ex.getMessage())
                        .status(
                                HttpStatus.NOT_FOUND.value()
                        )
                        .timestamp(
                                LocalDateTime.now()
                        )
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>
    handleGlobalException(
            Exception ex) {

        ErrorResponse response =
                ErrorResponse.builder()
                        .message(ex.getMessage())
                        .status(
                                HttpStatus.INTERNAL_SERVER_ERROR.value()
                        )
                        .timestamp(
                                LocalDateTime.now()
                        )
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}