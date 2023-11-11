package com.emvalai.authservice.controllers;

import com.emvalai.authservice.entities.AuthRequest;
import com.emvalai.authservice.entities.AuthResponse;
import com.emvalai.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService){
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<AuthResponse> logIn(@RequestBody AuthRequest authRequest){
        String status;
        AuthResponse response = new AuthResponse("", "", "",null);
        try{
            response = authService.logIn(authRequest);
            status = response.getStatus();
        }catch (Exception ex){
            status = ex.getLocalizedMessage();
        }
        AuthResponse authResponse = AuthResponse.builder()
                .accessToken(response.getAccessToken())
                .refreshToken(response.getRefreshToken())
                .status(status)
                .user(response.getUser())
                .build();
        return ResponseEntity.ok(authResponse);
    }

}
