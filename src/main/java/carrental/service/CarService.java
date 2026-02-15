package com.carrental.service;

import com.carrental.exception.NotFoundException;
import com.carrental.model.Car;
import com.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    public List<Car> getAll() {
        return repo.findAll();
    }

    public Car getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found with id: " + id));
    }

    public void add(Car car) {
        repo.save(car);
    }

    public void update(Long id, Car car) {
        repo.update(id, car);
    }

    public void delete(Long id) {
        repo.delete(id);
    }
}