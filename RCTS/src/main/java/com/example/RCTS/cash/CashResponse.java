package com.example.RCTS.cash;

public class CashResponse {
    public CashResponse(){

    }

    private String data;

    public CashResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
