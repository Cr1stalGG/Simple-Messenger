package com.simplemessenger.controller;

import com.simplemessenger.entity.dto.security.LoginRequest;
import com.simplemessenger.entity.dto.security.RegistrationRequest;
import com.simplemessenger.security.AuthenticationResponse;
import com.simplemessenger.service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {
    private final AccountServiceImpl accountService;

    @PostMapping("/up")
    public ResponseEntity<AuthenticationResponse> registration(@RequestBody RegistrationRequest request){
        return ResponseEntity.ok(accountService.addAccount(request));
    }

    @PostMapping("/in")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody LoginRequest request){
        return ResponseEntity.ok(accountService.authenticate(request));
    }
}
