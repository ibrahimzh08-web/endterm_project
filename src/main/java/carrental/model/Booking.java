package com.carrental.model;

public class Booking {

    private Long id;
    private Long carId;
    private String customerName;
    private int days;

    public Booking(Long id, Long carId, String customerName, int days) {
        this.id = id;
        this.carId = carId;
        this.customerName = customerName;
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public Long getCarId() {
        return carId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getDays() {
        return days;
    }
}