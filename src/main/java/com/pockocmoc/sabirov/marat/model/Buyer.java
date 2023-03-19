package com.pockocmoc.sabirov.marat.model;

public class Buyer {
    private int id;
    private String name;
    private String surname;
    private int checkNumber;
    private int phoneNumber;

    public Buyer(int id, String name, String surname, int checkNumber, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.checkNumber = checkNumber;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", checkNumber=" + checkNumber +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
