package com.banksphere.accountservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banksphere.accountservice.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Optional<Account> findByAccountNumber(String accountNumber);

}
