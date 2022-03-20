package com.example.RCTS.currency;

public class Currency {

    private int id;
    private String name;
    private float exchangeRateToBaht;

    public Currency(int id, String name, float exchangeRateToBaht) {
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

    public float getExchangeRateToBaht() {
        return exchangeRateToBaht;
    }

    public void setExchangeRateToBaht(float exchangeRateToBaht) {
        this.exchangeRateToBaht = exchangeRateToBaht;
    }
}

