package com.example.RCTS.currency;

public class CurrencyNotFoundException extends RuntimeException{
    public CurrencyNotFoundException(String message) {
        super(message);
    }
}

