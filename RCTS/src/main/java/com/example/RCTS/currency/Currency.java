package com.example.RCTS.currency;


import com.example.RCTS.cash.Cash;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Currency {

    @Id
    private int id;
    private String name;
    private double exchangeRateToBaht;

    @OneToMany(mappedBy = "currency")
    @JsonIgnore
    private List<Cash> cashList;

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

    public List<Cash> getCashList() {
        return cashList;
    }

    public void setCashList(List<Cash> cashList) {
        this.cashList = cashList;
    }
}

