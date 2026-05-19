package com.banksphere.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestDto {
	
	 @Email(message = "Invalid email format")
	    private String email;

	    @NotBlank(message = "Password is required")
	    private String password;

}
