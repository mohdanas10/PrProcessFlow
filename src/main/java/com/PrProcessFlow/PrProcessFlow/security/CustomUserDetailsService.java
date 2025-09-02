package com.PrProcessFlow.PrProcessFlow.security;

import com.PrProcessFlow.PrProcessFlow.Repository.PrRepo;
import com.PrProcessFlow.PrProcessFlow.Entity.User;
import com.PrProcessFlow.PrProcessFlow.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo   userRepo;// ✅ use your repo name

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from DB using your PrRepo
        User user = userRepo.findByEmailId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Convert your entity User -> Spring Security User
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmailId())
                .password(user.getPassword())
                .roles( user.getRole())   // assuming your User entity has `getRole()`
                .build();
    }
}
