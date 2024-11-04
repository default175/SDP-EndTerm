package org.example;
import lombok.*;

@Getter @Setter
public class RoomFactory {
    public static Room createRoom(Room.Type type, Room.BedType bedType, int price) {
        return new Room(type, bedType, price);
    }

    public static Room[] getAllRooms() {
        return new Room[]{
                createRoom(Room.Type.ECONOMY, Room.BedType.SINGLE, 50),
                createRoom(Room.Type.ECONOMY, Room.BedType.DOUBLE, 70),
                createRoom(Room.Type.STANDARD, Room.BedType.SINGLE, 100),
                createRoom(Room.Type.STANDARD, Room.BedType.DOUBLE, 120),

        };
    }
}
