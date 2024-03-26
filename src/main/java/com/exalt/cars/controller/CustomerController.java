package com.exalt.cars.controller;

import com.exalt.cars.dto.CustomerDto;
import com.exalt.cars.request.AuthenticationResponse;
import com.exalt.cars.service.AuthenticationService;
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
    private final AuthenticationService service;


    @PostMapping
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody @Valid CustomerDto customerDto
            ) {
        return ResponseEntity.ok(service.register(customerDto));
    }
}
