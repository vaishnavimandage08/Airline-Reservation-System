package com.solvd.airport.bin;

public class Airplane {

    private int airplaneId;
    private String capacity;

    public Airplane(int airplaneId, String capacity) {
        this.airplaneId = airplaneId;
        this.capacity = capacity;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

}
