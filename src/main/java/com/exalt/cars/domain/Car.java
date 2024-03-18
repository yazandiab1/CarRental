package com.exalt.cars.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(unique = true)
    @NotBlank(message = "Number is required")
    @Size(min = 3, max = 10, message = "Number must be between 3 and 10 characters")
    private String number;

    @NotBlank(message = "Type is required")
    @NonNull
    private String type;

    @NonNull
    @NotBlank(message = "Model is required")
    private String model;

    private String customerName;
    @Transient
    public boolean isAvailable() { // check if this car is available or not based on customer name property
        return customerName == null;
    }
}
