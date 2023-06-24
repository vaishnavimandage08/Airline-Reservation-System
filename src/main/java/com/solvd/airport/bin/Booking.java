package com.solvd.airport.bin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "booking")
public class Booking {

    @JsonProperty
    private int bookingId;
    @JsonProperty
    private int flightId;
    @JsonProperty
    private int passengerId;
    @JsonProperty
    private String seatNumber;
    @JsonProperty
    private Status status;
    @JsonProperty
    private int passengerDetailsId;

    public Booking() {

    }

    public enum Status {
        AVAILABLE,
        BOOKED,
        OCCUPIED
    }

    public Booking(int bookingId, int flightId, int passengerId, String seatNumber, Status status, int passengerDetailsId) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
        this.status = status;
        this.passengerDetailsId = passengerDetailsId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public Status getStatus() {
        return status;
    }

    public int getPassengerDetailsId() {
        return passengerDetailsId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPassengerDetailsId(int passengerDetailsId) {
        this.passengerDetailsId = passengerDetailsId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                ", seatNumber='" + seatNumber + '\'' +
                ", status=" + status +
                ", passengerDetailsId=" + passengerDetailsId +
                '}';
    }
}
