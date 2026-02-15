package com.carrental.model;

public abstract class Car {

    protected Long id;
    protected String brand;
    protected double pricePerDay;

    public Car(Long id, String brand, double pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
    }

    public abstract String getType();

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}