package com.banksphere.transactionservice.service.impl;

import com.banksphere.transactionservice.client.AccountClient;
import com.banksphere.transactionservice.dto.TransactionResponseDto;
import com.banksphere.transactionservice.dto.TransferRequestDto;
import com.banksphere.transactionservice.dto.client.AccountResponseDto;
import com.banksphere.transactionservice.dto.client.AmountRequestDto;
import com.banksphere.transactionservice.entity.Transaction;
import com.banksphere.transactionservice.enums.TransactionStatus;
import com.banksphere.transactionservice.enums.TransactionType;
import com.banksphere.transactionservice.exception.TransactionNotFoundException;
import com.banksphere.transactionservice.mapper.TransactionMapper;
import com.banksphere.transactionservice.repository.TransactionRepository;
import com.banksphere.transactionservice.service.TransactionService;
import com.banksphere.transactionservice.util.TransactionReferenceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository
            transactionRepository;
    
    private final AccountClient accountClient;

    @Override
    @Transactional
    public TransactionResponseDto transferMoney(
            TransferRequestDto requestDto) {

      
        AccountResponseDto senderAccount =
                accountClient.getAccount(
                        requestDto.getFromAccount()
                );

       
        AccountResponseDto receiverAccount =
                accountClient.getAccount(
                        requestDto.getToAccount()
                );

     
        if (senderAccount.getBalance()
                .compareTo(requestDto.getAmount()) < 0) {

            throw  new IllegalArgumentException(
                    "Insufficient balance"
            		);
        }

        Transaction transaction =
                Transaction.builder()
                        .transactionReference(
                                TransactionReferenceUtil
                                        .generateTransactionReference()
                        )
                        .fromAccount(
                                requestDto.getFromAccount()
                        )
                        .toAccount(
                                requestDto.getToAccount()
                        )
                        .amount(
                                requestDto.getAmount()
                        )
                        .transactionType(
                                TransactionType.TRANSFER
                        )
                        .transactionStatus(
                                TransactionStatus.PENDING
                        )
                        .transactionDate(
                                LocalDateTime.now()
                        )
                        .remarks(
                                requestDto.getRemarks()
                        )
                        .build();

        transaction = transactionRepository.save(transaction);
        AmountRequestDto amountRequest =
                AmountRequestDto.builder()
                        .amount(requestDto.getAmount())
                        .build();

        accountClient.debitAmount(
                requestDto.getFromAccount(),
                amountRequest
                
        );

       
        accountClient.creditAmount(
                requestDto.getToAccount(),
                amountRequest
        );
        transaction.setTransactionStatus(
                TransactionStatus.SUCCESS
        );

        Transaction savedTransaction =
                transactionRepository.save(transaction);

        return TransactionMapper
                .mapToTransactionResponseDto(
                        savedTransaction
                );
    }

	@Override
	public TransactionResponseDto getTransactionByReference(String transactionReference) {
		Transaction transaction=transactionRepository.findByTransactionReference(transactionReference)
				.orElseThrow(() ->
			    new TransactionNotFoundException(
			        "Transaction not found with reference: "
			                + transactionReference
			    )
			);
		
	 		return TransactionMapper
				.mapToTransactionResponseDto(
						transaction
				);
	}

	@Override
	public List<TransactionResponseDto>
	getAllTransactions() {

	    return transactionRepository
	            .findAll()
	            .stream()
	            .map(
	                    TransactionMapper
	                            ::mapToTransactionResponseDto
	            )
	            .toList();
	}
	
	@Override
	public List<TransactionResponseDto>
	getTransactionsByAccount(
	        String accountNumber) {

	    return transactionRepository
	            .findByFromAccountOrToAccount(
	                    accountNumber,
	                    accountNumber
	            )
	            .stream()
	            .map(
	                    TransactionMapper
	                            ::mapToTransactionResponseDto
	            )
	            .toList();
	}
		
		
	}