package com.example.RCTS.currency;

public class CurrencyResponse {
    public CurrencyResponse(){

    }

    private String data;

    public CurrencyResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
