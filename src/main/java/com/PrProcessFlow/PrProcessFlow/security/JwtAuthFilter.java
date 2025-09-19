package com.PrProcessFlow.PrProcessFlow.security;

import com.PrProcessFlow.PrProcessFlow.Repository.UserRepo;
import com.PrProcessFlow.PrProcessFlow.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepo userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println("---- JwtAuthFilter triggered ----");
        System.out.println("Request URI: " + request.getRequestURI());

        // 🔎 Dump all headers for debugging
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            System.out.println("Header -> " + name + " : " + request.getHeader(name));
        }

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("⚠️ Missing or invalid Authorization header");
        } else {
            token = authHeader.substring(7); // remove "Bearer "
            try {
                username = jwtService.extractUsername(token);
                System.out.println("Extracted username from token: " + username);
            } catch (Exception e) {
                System.out.println("❌ Failed to extract username: " + e.getMessage());
            }
        }

        // Continue only if username extracted and no authentication yet
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (userDetails != null && jwtService.validateToken(token, userDetails.getUsername())) {
                String role = jwtService.extractRole(token);
                System.out.println("✅ Token valid. Role: " + role);

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                List.of(new SimpleGrantedAuthority("ROLE_" + role))
                        );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                System.out.println("❌ Invalid token for user: " + username);
            }
        }

        filterChain.doFilter(request, response);
    }
}