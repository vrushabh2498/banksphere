package com.banksphere.accountservice.entity;

import java.math.BigDecimal;

import com.banksphere.accountservice.enums.AccountStatus;
import com.banksphere.accountservice.enums.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
@Builder
public class Account extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account_number", nullable = false, unique = true)
	private String accountNumber;

	@Column(name = "account_holder_name", nullable = false)
	private String accountHolderName;

	@Column(nullable = false)
	private BigDecimal balance;

	@Enumerated(EnumType.STRING)
	@Column(name = "account_type", nullable = false)
	private AccountType accountType;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AccountStatus status;


}
