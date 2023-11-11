package com.emvalai.authservice.services;

import com.emvalai.authservice.entities.AuthRequest;
import com.emvalai.authservice.entities.AuthResponse;
import com.emvalai.authservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtUtil jwt;

    @Autowired
    public AuthService(final JwtUtil jwt){
        this.jwt = jwt;
    }

    public AuthResponse logIn(AuthRequest authRequest){
        // check login here

        User user = User.builder()
                .userId("5")
                .email(authRequest.getEmail())
                .role("HR")
                .build();
        String accessToken = jwt.generate(user, "ACCESS");
        String refreshToken =  jwt.generate(user, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }

}
