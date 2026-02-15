package com.carrental.patterns.factory;

import com.carrental.model.*;

public class CarFactory {

    public static Car createCar(String type, Long id, String brand, double pricePerDay) {

        if (type == null) {
            throw new IllegalArgumentException("Car type cannot be null");
        }

        switch (type.toUpperCase()) {

            case "SUV":
                return new SUV(id, brand, pricePerDay);

            case "SEDAN":
                return new Sedan(id, brand, pricePerDay);

            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}