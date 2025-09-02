package com.PrProcessFlow.PrProcessFlow.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    private final String SECRET_KEY = "qP8vL4rF7xZ9dM3sV6bN1wT0yU2eR5gH898djunlslihs"; // must be >= 32 chars
    private final long EXP_MS = 1000L * 60 * 60 * 2; // 3 hours

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Generate JWT with username + role
    public String generateToken(String emailId, String role) {
        return Jwts.builder()
                .setSubject(emailId)
                .claim("role", role)    // include role in token
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXP_MS))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return getAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return getAllClaims(token).get("role", String.class);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return getAllClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }
}
