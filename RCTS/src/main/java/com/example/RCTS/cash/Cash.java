package com.example.RCTS.cash;

import com.example.RCTS.currency.Currency;

public class Cash {

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
