package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/Hotel";
    private final String username = "postgres";
    private final String password = "123";

    private DatabaseConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to create the database connection.");
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
