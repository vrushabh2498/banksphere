package com.banksphere.authservice.service.impl;

import com.banksphere.authservice.dto.RegisterRequestDto;
import com.banksphere.authservice.dto.RegisterResponseDto;

public interface AuthService  {
	
	RegisterResponseDto registerUser(RegisterRequestDto requestDto);

}
