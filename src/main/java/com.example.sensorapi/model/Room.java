package com.example.sensorapi.model;

public class Room {

    private String roomId;
    private String name;
    private String building;
    private int floor;

    public Room() {}

    public Room(String roomId, String name, String building, int floor) {
        this.roomId = roomId;
        this.name = name;
        this.building = building;
        this.floor = floor;
    }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBuilding() { return building; }
    public void setBuilding(String building) { this.building = building; }

    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }
}