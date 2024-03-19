package com.exalt.cars.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    private Long id;

    @NotBlank(message = "Number is required")
    @Size(min = 3, max = 10, message = "Number must be between 3 and 10 characters")
    private String number;

    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "Model is required")
    private String model;
}
