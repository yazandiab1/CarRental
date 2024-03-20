package com.exalt.cars.service;

import com.exalt.cars.domain.Car;
import com.exalt.cars.dto.CarMapper;
import com.exalt.cars.exception.CarNotAvailableException;
import com.exalt.cars.exception.CarNotFoundException;
import com.exalt.cars.repository.CarRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository ) {
        this.carRepository = carRepository;
    }

    public Car getCar(String number) {
        return carRepository.findByNumber(number).get();
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

    @Transactional
    public void rentCar(String number, String customerName){
        Optional<Car> optionalCar = carRepository.findByNumber(number);

        if ( optionalCar.isPresent() ) {
            Car car = optionalCar.get();
            if ( car.isAvailable() ) {
                car.setCustomerName(customerName);
                carRepository.save(car);
            } else {
                throw new CarNotAvailableException("Car is not available for rent.");
            }
        } else {
            throw new CarNotFoundException("Car not found for Number: " + number);
        }

    }


    public Car addCar(@Valid Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(String number) {
        Optional<Car> carOptional = carRepository.findByNumber(number);
        if (carOptional.isPresent()) {
            carRepository.delete(carOptional.get());
            return;
        }

        throw new CarNotFoundException("Car not found for Number: " + number);
    }

}
