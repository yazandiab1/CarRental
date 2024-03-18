package com.exalt.cars.controller;


import com.exalt.cars.domain.Car;
import com.exalt.cars.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/available")
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

    @PostMapping("/rent/{number}/{customerName}")
    public String  rentCar(@PathVariable String number, @PathVariable String customerName) {
        return carService.rentCar(number, customerName);
    }
}
