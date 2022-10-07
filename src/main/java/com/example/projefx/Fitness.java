package com.example.projefx;

public class Fitness {
    private int id;
    private String name;
    private String surname;
    private String membership;
    private String startDate;
    private String expirationDate;
    private int discount;
    private int totalPrice;

    public Fitness(int id, String name, String surname, String membership, String startDate, String expirationDate, int discount, int totalPrice) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.membership = membership;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.discount = discount;
        this.totalPrice = totalPrice;
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

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}

