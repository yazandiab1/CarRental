package com.exalt.cars.service;

import com.exalt.cars.domain.Car;
import com.exalt.cars.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getAvailableCars() {
        List<Car> allCars = carRepository.findAll();
        return allCars.stream()
                .filter(car -> car.getCustomerName() == null || car.getCustomerName().isEmpty())
                .collect(Collectors.toList());
    }

    public String rentCar(String number, String customerName){
        Optional<Car> optionalCar = carRepository.findByNumber(number);

        if ( optionalCar.isPresent() ) {
            Car car = optionalCar.get();
            if ( car.isAvailable() ) {
                car.setCustomerName(customerName);
                carRepository.save(car);
                return "The car has been successfully rented";
            } else {
                return "Car is not available for rent.";
            }
        } else {
            return "Car not found for Number: " + number;
        }

    }

}
