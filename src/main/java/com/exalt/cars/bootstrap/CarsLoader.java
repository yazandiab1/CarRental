package com.exalt.cars.bootstrap;

import com.exalt.cars.domain.Car;
import com.exalt.cars.repository.CarRepository;
import com.exalt.cars.service.CarService;
import com.exalt.cars.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CarsLoader implements CommandLineRunner {

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {

        Car skoda = new Car("111","skoda","2019");
        carRepository.save(skoda);

        Car bmw = new Car("222","BMW","2022");
        carRepository.save(bmw);

        Car kia = new Car("333","KIA","2020");
        carRepository.save(kia);

    }
}
