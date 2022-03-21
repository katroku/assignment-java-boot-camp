package com.example.RCTS.currency;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {

    @Id
    private int id;
    private String name;
    private double exchangeRateToBaht;

    public Currency(int id, String name, double exchangeRateToBaht) {
        this.id = id;
        this.name = name;
        this.exchangeRateToBaht = exchangeRateToBaht;
    }

    public Currency() {
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

    public double getExchangeRateToBaht() {
        return exchangeRateToBaht;
    }

    public void setExchangeRateToBaht(double exchangeRateToBaht) {
        this.exchangeRateToBaht = exchangeRateToBaht;
    }
}

