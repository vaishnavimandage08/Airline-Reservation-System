package com.solvd.airport.bin;

import java.time.LocalDateTime;

public class Payment {
    private int paymentId;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private int amount;
    private int bookingId;
    private int passengerDetailsId;

    public Payment(int paymentId, String paymentMethod, LocalDateTime paymentDate, int amount, int bookingId, int passengerDetailsId) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.bookingId = bookingId;
        this.passengerDetailsId = passengerDetailsId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public int getAmount() {
        return amount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getPassengerDetailsId() {
        return passengerDetailsId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setPassengerDetailsId(int passengerDetailsId) {
        this.passengerDetailsId = passengerDetailsId;
    }
}
