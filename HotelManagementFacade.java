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

    public static void bookRoomForClient(Connection connection, Client client) throws SQLException {
        Room[] allRooms = Room.getAllRooms();
        Room chosenRoom = client.chooseRoom(allRooms); // Получаем выбранную комнату
        if (chosenRoom != null) { // Проверяем, выбрана ли комната
            String sql = "UPDATE room SET booked = TRUE WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, chosenRoom.getId()); // Устанавливаем id выбранной комнаты
                statement.executeUpdate();
                System.out.println("Room booked for client: " + client.getName());
            }
        } else {
            System.out.println("No room was chosen for client: " + client.getName());
        }
    }
}
