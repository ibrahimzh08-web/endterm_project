package com.carrental.patterns.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

    private static DatabaseConfig instance;
    private Connection connection;

    private DatabaseConfig() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/car_rental",
                    "postgres",
                    "Sandigul1"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}