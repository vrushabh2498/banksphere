package com.banksphere.authservice.security.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private Key getSigningKey() {

        return Keys.hmacShaKeyFor(
                secretKey.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateToken(
            String email,
            String role) {

        Date issuedAt = new Date();

        Date expirationDate = new Date(
                issuedAt.getTime() + jwtExpiration
        );

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuer("BankSphere")
                .setIssuedAt(issuedAt)
                .setExpiration(expirationDate)
                .signWith(
                        getSigningKey(),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }

    private Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver) {

        Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    public String extractEmail(String token) {

        return extractClaim(
                token,
                Claims::getSubject
        );
    }

    public Date extractExpiration(String token) {

        return extractClaim(
                token,
                Claims::getExpiration
        );
    }

    private boolean isTokenExpired(String token) {

        return extractExpiration(token)
                .before(new Date());
    }

    public boolean isTokenValid(
            String token,
            String email) {

        final String extractedEmail =
                extractEmail(token);

        return extractedEmail.equals(email)
                && !isTokenExpired(token);
    }
}