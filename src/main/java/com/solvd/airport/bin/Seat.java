package com.solvd.airport.bin;


public class Seat {
    private int seatId;
    private String seatNumber;
    private ClassType classType;
    private String status;
    private int airplaneId;

    public enum ClassType {
        ECONOMY,
        BUSINESS,
        FIRST
    }

    public Seat(int seatId, String seatNumber, ClassType classType, String status, int airplaneId) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.status = status;
        this.airplaneId = airplaneId;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public ClassType getClassType() {
        return classType;
    }

    public String getStatus() {
        return status;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }
}
