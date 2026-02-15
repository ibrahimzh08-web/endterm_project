package com.carrental.model;

public class Sedan extends Car {

    public Sedan(Long id, String brand, double pricePerDay) {
        super(id, brand, pricePerDay);
    }

    @Override
    public String getType() {
        return "SEDAN";
    }
}