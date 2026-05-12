package com.banksphere.authservice.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksphere.authservice.dto.LoginRequestDto;
import com.banksphere.authservice.dto.LoginResponseDto;
import com.banksphere.authservice.dto.RegisterRequestDto;
import com.banksphere.authservice.dto.RegisterResponseDto;
import com.banksphere.authservice.service.impl.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth/")
@Validated
public class AuthController {
	
	private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
	
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> registerUser(
            @Valid @RequestBody RegisterRequestDto requestDto) {

        RegisterResponseDto response =
                authService.registerUser(requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginRequestDto requestDto){
    	LoginResponseDto response=authService.loginUser(requestDto);
    	return new ResponseEntity<>(response,HttpStatus.OK);
    }
	

}
