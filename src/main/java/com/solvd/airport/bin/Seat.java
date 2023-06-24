package com.solvd.airport.bin;


import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Seat {
    @XmlAttribute
    private int seatId;
    @XmlElement(name = "seatNumber")
    private String seatNumber;
    @XmlElement
    private ClassType classType;
    @XmlElement
    private String status;
    @XmlElement
    private int airplaneId;

    public enum ClassType {
        ECONOMY,
        BUSINESS,
        FIRST
    }

    public Seat() {
        // Default no-argument constructor
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
