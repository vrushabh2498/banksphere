package com.banksphere.authservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.banksphere.authservice.security.filter.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(
	        HttpSecurity http)
	        throws Exception {

	    http

	            
	            .csrf(AbstractHttpConfigurer::disable)
	            .sessionManagement(session ->
	                    session.sessionCreationPolicy(
	                            SessionCreationPolicy.STATELESS
	                    )
	            )
	            .authorizeHttpRequests(auth -> auth
	                    .requestMatchers("/api/v1/auth/**")
	                    .permitAll()

	                    .requestMatchers("/api/v1/admin/**")
	                    .hasRole("ADMIN")

	                    .requestMatchers("/api/v1/employee/**")
	                    .hasAnyRole("EMPLOYEE", "ADMIN")

	                    .requestMatchers("/api/v1/customer/**")
	                    .hasAnyRole(
	                            "CUSTOMER",
	                            "EMPLOYEE",
	                            "ADMIN"
	                    )

	                    .anyRequest()
	                    .authenticated()
	            )

	            .addFilterBefore(
	                    jwtAuthenticationFilter,
	                    UsernamePasswordAuthenticationFilter.class
	            );

	    return http.build();
	}

}