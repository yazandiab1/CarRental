package com.exalt.cars.service;

import com.exalt.cars.domain.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    public Car getCar(String number);

    //get all cars
    public List<Car> getAllCars();

    //get all available cars ( not rented yet; does not have customer name )
    public List<Car> getAvailableCars();

    //rent car based on car number (unique) and then set customer name
    public String rentCar(String number, String customerName);

    //add new car
    public Car addCar(Car car);

    //delete car by number
    public String deleteCar(String number);
}
