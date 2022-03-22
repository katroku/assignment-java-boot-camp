package com.example.RCTS.cash;

import com.example.RCTS.cashbox.CashBox;
import com.example.RCTS.currency.Currency;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonBackReference //this will not display currency
    private Currency currency;
    private float amount;

    @ManyToOne
    @JoinColumn(name = "cashbox_id", nullable = true)
    @JsonBackReference
    private CashBox cashBox;

    public Cash() {

    }

    public Cash(int id, Currency currency, float amount) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CashBox getCashBox() {
        return cashBox;
    }

    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
    }

}
