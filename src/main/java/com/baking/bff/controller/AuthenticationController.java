package com.baking.bff.controller;

import com.baking.bff.model.LoginResponse;
import com.baking.bff.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public ResponseEntity<LoginResponse> authenticate(Authentication authentication) {
        LoginResponse token = authenticationService.authenticate(authentication);
        return ResponseEntity.ok(token);
    }
}
