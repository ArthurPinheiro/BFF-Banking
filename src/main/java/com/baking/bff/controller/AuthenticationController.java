package com.baking.bff.controller;

import com.baking.bff.config.ExceptionConfig;
import com.baking.bff.model.LoginResponse;
import com.baking.bff.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse> authenticate(Authentication authentication) {
        LoginResponse token = authenticationService.authenticate(authentication);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/error")
    public String error() throws Exception {
        throw new ExceptionConfig("Mensagem de erro", "Erro ao efetuar login");
    }
}
