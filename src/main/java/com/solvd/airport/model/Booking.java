package com.solvd.airport.model;

public class Booking {
    private int bookingId;
    private int flightId;
    private int passengerId;
    private String seatNumber;
    private Status status;
    private int passengerDetailsId;

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
}
