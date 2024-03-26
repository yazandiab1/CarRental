package com.exalt.cars.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {
    @NonNull
    @NotBlank(message = "Name is required")
    private String name;

    @NonNull
    @NotBlank(message = "Email is required")
    private String email;

    @NonNull
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NonNull
    @NotBlank(message = "Phone Number is required")
    @Size(min = 10, message = "Phone Number must be at least 10 characters")
    private String phoneNumber;

}

