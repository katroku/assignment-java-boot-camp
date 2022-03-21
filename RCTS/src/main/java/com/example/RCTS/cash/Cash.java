package com.example.RCTS.cash;

import com.example.RCTS.currency.Currency;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cash {

    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name="currency_id")
    @JsonBackReference
    private Currency currency;
    private float amount;

    public Cash() {

    }

    public Cash(Currency currency, float amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
