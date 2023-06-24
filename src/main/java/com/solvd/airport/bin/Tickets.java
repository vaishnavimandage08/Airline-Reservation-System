package com.solvd.airport.bin;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDateTime;

@JsonRootName(value = "tickets")
public class Tickets {
    @JsonProperty

    private int ticketId;
    @JsonProperty

    private String seatNumber;
    @JsonProperty

    private int price;
    @JsonProperty
    private LocalDateTime purchaseDate;
    @JsonProperty
    private int seatId;
    @JsonProperty
    private int passengerDetailsId;

    public Tickets() {

    }

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

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", seatNumber='" + seatNumber + '\'' +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                ", seatId=" + seatId +
                ", passengerDetailsId=" + passengerDetailsId +
                '}';
    }
}
