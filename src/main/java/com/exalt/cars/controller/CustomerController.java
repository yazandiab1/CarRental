package com.exalt.cars.controller;

import com.exalt.cars.dto.CustomerDto;
import com.exalt.cars.request.AuthenticationRequest;
import com.exalt.cars.request.AuthenticationResponse;
import com.exalt.cars.service.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final AuthenticationServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody @Valid CustomerDto customerDto
    ) {
        return ResponseEntity.ok(service.register(customerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
            ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}
