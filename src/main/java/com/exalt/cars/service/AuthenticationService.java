package com.exalt.cars.service;

import com.exalt.cars.config.JwtService;
import com.exalt.cars.domain.Customer;
import com.exalt.cars.domain.Role;
import com.exalt.cars.dto.CustomerDto;
import com.exalt.cars.repository.CustomerRepository;
import com.exalt.cars.request.AuthenticationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(@Valid CustomerDto request) {
        var customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(Role.CUSTOMER)
                .build();

        repository.save(customer);
        var jwtToken = jwtService.generateToken(customer);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}