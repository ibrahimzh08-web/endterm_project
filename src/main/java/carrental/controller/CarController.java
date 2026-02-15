package com.carrental.controller;

import com.carrental.dto.CarRequest;
import com.carrental.model.Car;
import com.carrental.patterns.factory.CarFactory;
import com.carrental.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public String createCar(@RequestBody CarRequest request) {

        Car car = CarFactory.createCar(
                request.getType(),
                null,
                request.getBrand(),
                request.getPricePerDay()
        );

        service.add(car);

        return "Car added successfully!";
    }

    @PutMapping("/{id}")
    public String updateCar(@PathVariable Long id,
                            @RequestBody CarRequest request) {

        Car updatedCar = CarFactory.createCar(
                request.getType(),
                id,
                request.getBrand(),
                request.getPricePerDay()
        );

        service.update(id, updatedCar);

        return "Car updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {

        service.delete(id);

        return "Car deleted successfully!";
    }
}