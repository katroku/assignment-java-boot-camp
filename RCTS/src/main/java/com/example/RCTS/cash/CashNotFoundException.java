package com.example.RCTS.cash;

public class CashNotFoundException  extends RuntimeException{

    public CashNotFoundException(String message) {
        super(message);
    }
}
