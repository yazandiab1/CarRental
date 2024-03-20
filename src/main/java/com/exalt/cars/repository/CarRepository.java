package com.exalt.cars.repository;

import com.exalt.cars.domain.Car;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Lock(value = LockModeType.OPTIMISTIC)
    Optional<Car> findByNumber(String number);
}
