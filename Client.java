package org.example;
import java.util.Scanner;
import lombok.*;
import org.example.interfaces.User;
import org.example.interfaces.Observer;

@Getter
@Setter
public class Client extends Person implements User, Observer {
    private double money;
    private Room room;
    private Scanner sc;

    public Client(String name, double money, Scanner sc) {
        super(name);
        this.money = money;
        this.sc = sc;
    }

    public Room chooseRoom(Room[] rooms) {
        int choice;
        System.out.println(this.getName() + " please choose room type:");
        do {
            for (int i = 0; i < rooms.length; i++) {
                System.out.println((i + 1) + ": " + rooms[i]);
            }
            System.out.print("Choose room:");
            choice = sc.nextInt();
            if (choice > 0 && choice <= rooms.length && money >= rooms[choice - 1].getPrice()) {
                return rooms[choice - 1];
            } else if (choice != 0 && choice > rooms.length) {
                System.out.println("There is no such room");
                return null;
            }
            System.out.println(this.getName() + " doesn't have enough money. Choose another or enter '0' to exit.");
        } while (choice != 0);
        return null;
    }

    @Override
    public void update(String message) {
        System.out.println(this.getName() + " received notification: " + message);
    }

    @Override
    public void addMoney(double amount) { }
    @Override
    public void deductMoney(double amount) { }
}
