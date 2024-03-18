package com.exalt.cars.repository;

import com.exalt.cars.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByNumber(String number);
}
