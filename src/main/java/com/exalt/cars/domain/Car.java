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
    private String number;

    @NonNull
    private String type;

    @NonNull
    private String model;

    private String customerName;
    @Transient
    public boolean isAvailable() { // check if this car is available or not based on customer name property
        return customerName == null;
    }
}
