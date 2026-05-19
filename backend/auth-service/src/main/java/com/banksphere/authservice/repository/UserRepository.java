package com.banksphere.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banksphere.authservice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
Optional<UserEntity> findByEmail(String email);

Optional<UserEntity> findByMobileNumber(String mobileNumber);

boolean existsByEmail(String email);

boolean existsByMobileNumber(String mobileNumber);


}
