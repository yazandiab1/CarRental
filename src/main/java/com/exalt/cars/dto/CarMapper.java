package com.exalt.cars.dto;

import com.exalt.cars.domain.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true) // ignore id during mapping from DTO to entity
    Car dtoToEntity(CarDto carDto);

    CarDto entityToDto(Car car);
}