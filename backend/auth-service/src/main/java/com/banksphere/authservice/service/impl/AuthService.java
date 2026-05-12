package com.banksphere.authservice.service.impl;

import com.banksphere.authservice.dto.LoginRequestDto;
import com.banksphere.authservice.dto.LoginResponseDto;
import com.banksphere.authservice.dto.RegisterRequestDto;
import com.banksphere.authservice.dto.RegisterResponseDto;

public interface AuthService  {
	
	RegisterResponseDto registerUser(RegisterRequestDto requestDto);
	LoginResponseDto loginUser(LoginRequestDto requestDto);

}
