package com.exalt.cars.service;

import com.exalt.cars.dto.CustomerDto;
import com.exalt.cars.request.AuthenticationRequest;
import com.exalt.cars.request.AuthenticationResponse;
import jakarta.validation.Valid;

public interface AuthenticationSerivce {

    //register new customer
    public AuthenticationResponse register(@Valid CustomerDto request);

    //login
    public AuthenticationResponse authenticate(AuthenticationRequest request);
    }
