package com.banksphere.authservice.dto;

import com.banksphere.authservice.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class RegisterRequestDto {
	
	@NotBlank(message = "fullname is required")
	private String fullname;
	
	@Email(message = "email should be valid")
	@NotBlank(message = "email is required")
	private String email;
	
	@NotBlank(message = "mobileNumber is required")
	 @Pattern(
	            regexp = "^[0-9]{10}$",
	            message = "Mobile number must be 10 digits"
	    )
	private String mobileNumber;
	
	 @NotBlank(message = "Password is required")
	    private String password;

	    private Role role;

}
