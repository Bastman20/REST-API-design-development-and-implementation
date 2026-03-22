package com.example.sensorapi.model;

public class SensorReading {

    private String readingId;
    private double value;
    private String timestamp;

    public SensorReading() {}

    public SensorReading(String readingId, double value, String timestamp) {
        this.readingId = readingId;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getReadingId() { return readingId; }
    public void setReadingId(String readingId) { this.readingId = readingId; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}