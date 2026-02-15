package com.carrental.patterns.builder;

import com.carrental.model.Booking;

public class BookingBuilder {

    private Long id;
    private Long carId;
    private String customerName;
    private int days;

    public BookingBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public BookingBuilder setCarId(Long carId) {
        this.carId = carId;
        return this;
    }

    public BookingBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public BookingBuilder setDays(int days) {
        this.days = days;
        return this;
    }

    public Booking build() {
        return new Booking(id, carId, customerName, days);
    }
}