package com.carrental.model;

public class SUV extends Car {

    public SUV(Long id, String brand, double pricePerDay) {
        super(id, brand, pricePerDay);
    }

    @Override
    public String getType() {
        return "SUV";
    }
}