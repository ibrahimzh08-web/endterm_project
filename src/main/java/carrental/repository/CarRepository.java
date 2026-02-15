package com.carrental.repository;

import com.carrental.model.Car;
import com.carrental.model.Sedan;
import com.carrental.patterns.singleton.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class CarRepository {

    private final Connection conn = DatabaseConfig.getInstance().getConnection();

    public List<Car> findAll() {

        List<Car> cars = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars");

            while (rs.next()) {
                cars.add(new Sedan(
                        rs.getLong("id"),
                        rs.getString("brand"),
                        rs.getDouble("price_per_day")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cars;
    }

    public Optional<Car> findById(Long id) {

        try {
            PreparedStatement ps =
                    conn.prepareStatement("SELECT * FROM cars WHERE id=?");

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Optional.of(new Sedan(
                        rs.getLong("id"),
                        rs.getString("brand"),
                        rs.getDouble("price_per_day")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void save(Car car) {

        try {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "INSERT INTO cars(brand,type,price_per_day) VALUES (?,?,?)"
                    );

            ps.setString(1, car.getBrand());
            ps.setString(2, car.getType());
            ps.setDouble(3, car.getPricePerDay());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Long id, Car car) {

        try {
            PreparedStatement ps =
                    conn.prepareStatement(
                            "UPDATE cars SET brand=?, type=?, price_per_day=? WHERE id=?"
                    );

            ps.setString(1, car.getBrand());
            ps.setString(2, car.getType());
            ps.setDouble(3, car.getPricePerDay());
            ps.setLong(4, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {

        try {
            PreparedStatement ps =
                    conn.prepareStatement("DELETE FROM cars WHERE id=?");

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}