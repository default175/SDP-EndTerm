package org.example;

import java.sql.*;

public class HotelManagementFacade {
    private Connection connection;
    private NotificationService notificationService;

    public HotelManagementFacade(Connection connection, NotificationService notificationService) {
        this.connection = connection;
        this.notificationService = notificationService;
    }

    public void addClientToDatabase(Client client) throws SQLException {
        String sql = "INSERT INTO clients (name, money) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, client.getName());
            statement.setDouble(2, client.getMoney());
            statement.executeUpdate();
            notificationService.notifyObservers("New client added: " + client.getName());
        }
    }


}
