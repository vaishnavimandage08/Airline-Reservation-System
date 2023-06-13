package com.solvd.airport.bin;

public class PassengerDetails {
    private int passengerId;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String emailAddress;
    private String phoneNumber;
    private int age;
    private String gender;

    public PassengerDetails(int passengerId, String firstName, String lastName, String passportNumber, String emailAddress, String phoneNumber, int age, String gender) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
