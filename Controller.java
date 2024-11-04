package org.example;

import org.example.Client;
import org.example.Room;
import org.example.Staff;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class Controller {

    private List<Client> clients = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();


    @GetMapping("/clients/getAllClients")
    public List<Client> getAllClients() {
        return clients;
    }


    @PostMapping("/clients/addClient")
    public String addClient(@RequestBody Client client) {
        clients.add(client);
        return "Клиент добавлен: " + client.getName();
    }


    @PutMapping("/clients/{name}")
    public String updateClient(@PathVariable String name, @RequestBody Client updatedClient) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                client.setMoney(updatedClient.getMoney());
                return "Клиент обновлен: " + client.getName();
            }
        }
        return "Клиент не найден!";
    }


    @DeleteMapping("/clients/{name}")
    public String deleteClient(@PathVariable String name) {
        clients.removeIf(client -> client.getName().equals(name));
        return "Клиент удален: " + name;
    }


    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return List.of(Room.getAllRooms());
    }


    @GetMapping("/staff/getAllStaff")
    public List<Staff> getAllStaff() {
        return staffList;
    }


    @PostMapping("/staff")
    public String addStaff(@RequestBody Staff staff) {
        staffList.add(staff);
        return "Сотрудник добавлен: " + staff.getName();
    }
}
