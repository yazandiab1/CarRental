package com.exalt.cars.controller;


import com.exalt.cars.domain.Car;
import com.exalt.cars.request.RentCarRequest;
import com.exalt.cars.service.CarServiceImpl;
import jakarta.validation.Valid;
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

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car addCar(@RequestBody @Valid Car car) {
        return carService.addCar(car);
    }

    @DeleteMapping("/{number}")
    public String deleteCar(@PathVariable String number) {
        return carService.deleteCar(number);
    }

    @GetMapping("/{number}")
    public Car getCar(@PathVariable String number) {
        return carService.getCar(number);
    }

    @GetMapping("/available")
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

    @PostMapping("/rent")
    public String rentCar(@RequestBody RentCarRequest rentCarRequest) {
        String number = rentCarRequest.getNumber();
        String customerName = rentCarRequest.getCustomerName();
        return carService.rentCar(number,customerName);
    }
}
