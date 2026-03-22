package com.example.sensorapi.model;

public class Sensor {

    private String sensorId;
    private String name;
    private String type;
    private String roomId;
    private String status;
    private Double currentValue;

    public Sensor() {}

    public Sensor(String sensorId, String name, String type, String roomId, String status, Double currentValue) {
        this.sensorId = sensorId;
        this.name = name;
        this.type = type;
        this.roomId = roomId;
        this.status = status;
        this.currentValue = currentValue;
    }

    public String getSensorId() { return sensorId; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getCurrentValue() { return currentValue; }
    public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }
}