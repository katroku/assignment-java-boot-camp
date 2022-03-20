package com.example.RCTS.cashbox;

public class CashBoxNotFoundException extends RuntimeException{
    public CashBoxNotFoundException(String message) {
        super(message);
    }
}

