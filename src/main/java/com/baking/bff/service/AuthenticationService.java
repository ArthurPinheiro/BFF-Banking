package com.baking.bff.service;

import com.baking.bff.model.LoginResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public LoginResponse authenticate(Authentication authentication) {
        return new LoginResponse(jwtService.generateToken(authentication));
    }
}
