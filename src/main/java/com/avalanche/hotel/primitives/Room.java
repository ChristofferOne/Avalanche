package com.avalanche.hotel.primitives;

public class Room {
    private RoomNumber roomNumber;
    private int beds;
    private Money price;

    public Room(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
    }
}
