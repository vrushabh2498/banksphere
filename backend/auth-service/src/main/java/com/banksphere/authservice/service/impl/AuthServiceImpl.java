package com.banksphere.authservice.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.banksphere.authservice.dto.RegisterRequestDto;
import com.banksphere.authservice.dto.RegisterResponseDto;
import com.banksphere.authservice.entity.UserEntity;
import com.banksphere.authservice.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AuthServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
	    this.userRepository = userRepository;
	    this.passwordEncoder=passwordEncoder;
	}
	
	private static final Logger logger= LoggerFactory.getLogger(AuthServiceImpl.class);

	@Override
	public RegisterResponseDto registerUser(RegisterRequestDto requestDto) {
		
		logger.info("User registration started for email: {}",
                requestDto.getEmail());
		if (userRepository.existsByEmail(requestDto.getEmail())) {

		    logger.warn("Registration failed. Email already exists: {}",
		            requestDto.getEmail());

		    throw new RuntimeException("Email already registered");
		}

		if (userRepository.existsByMobileNumber(requestDto.getMobileNumber())) {

		    logger.warn("Registration failed. Mobile number already exists: {}",
		            requestDto.getMobileNumber());

		    throw new RuntimeException("Mobile number already registered");
		}
		
		UserEntity user= new UserEntity();
		user.setFullName(requestDto.getFullname());
		user.setEmail(requestDto.getEmail());
		user.setMobileNumber(requestDto.getMobileNumber());
		user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
		user.setRole(requestDto.getRole());
		user.setActive(true);
		
		UserEntity savedUser= userRepository.save(user);
		
		logger.info("User registration successful for email: {}",
				requestDto.getEmail());
		
		return new RegisterResponseDto(savedUser.getId(), "User registered successfully");
		
	}
	
	

}
