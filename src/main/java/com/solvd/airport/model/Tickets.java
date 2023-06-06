package com.solvd.airport.model;

import java.time.LocalDateTime;

public class Tickets {
    private int ticketId;
    private String seatNumber;
    private int price;
    private LocalDateTime purchaseDate;
    private int seatId;
    private int passengerDetailsId;

    public Tickets(int ticketId, String seatNumber, int price, LocalDateTime purchaseDate, int seatId, int passengerDetailsId) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.seatId = seatId;
        this.passengerDetailsId = passengerDetailsId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getPassengerDetailsId() {
        return passengerDetailsId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setPassengerDetailsId(int passengerDetailsId) {
        this.passengerDetailsId = passengerDetailsId;
    }
}
