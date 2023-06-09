package com.solvd.airport.bin;

public class PassangerAddress {
    private int id;
    private String address;
    private String country;
    private int passengerDetailsId;

    public PassangerAddress(int id, String address, String country, int passengerDetailsId) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.passengerDetailsId = passengerDetailsId;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public int getPassengerDetailsId() {
        return passengerDetailsId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassengerDetailsId(int passengerDetailsId) {
        this.passengerDetailsId = passengerDetailsId;
    }
}
