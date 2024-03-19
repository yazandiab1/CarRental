package com.exalt.cars.controller;


import com.exalt.cars.domain.Car;
import com.exalt.cars.dto.CarDto;
import com.exalt.cars.dto.CarMapper;
import com.exalt.cars.exception.CarNotAvailableException;
import com.exalt.cars.exception.CarNotFoundException;
import com.exalt.cars.request.RentCarRequest;
import com.exalt.cars.service.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/cars")
public class CarController {

    private CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@Valid @RequestBody CarDto carDto) {

        //convert CarDto to Car entity
        Car car = carService.carMapper.dtoToEntity(carDto);

        //save car
        Car savedCar = carService.addCar(car);

        //convert Car entity to CarDto
        CarDto carResponse = carService.carMapper.entityToDto(savedCar);

        return new ResponseEntity<>(carResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteCar(@PathVariable String number) {
        carService.deleteCar(number);
        return ResponseEntity.ok("The car has been successfully deleted");
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
    public ResponseEntity<String> rentCar(@RequestBody RentCarRequest rentCarRequest) {
        carService.rentCar(rentCarRequest.getNumber(),rentCarRequest.getCustomerName());
        return ResponseEntity.ok("The car has been successfully rented");
    }

    @ExceptionHandler({CarNotAvailableException.class, CarNotFoundException.class})
    public ResponseEntity<String> handleCarExceptions(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
