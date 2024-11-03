package org.example;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "123";
        Scanner sc = new Scanner(System.in);
        NotificationService notificationService = new NotificationService();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            HotelManagementFacade hotelFacade = new HotelManagementFacade(connection, notificationService);

            Client client = new Client("John Doe", 500.0, sc);
            notificationService.addObserver(client);

            hotelFacade.addClientToDatabase(client);
            hotelFacade.bookRoomForClient(connection,client);

            Staff staff = new Staff("Alice Johnson", "Waiter", 15.0, new HourlySalaryStrategy());
            staff.addHoursWorked(40);
            staff.paySalary();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}