package com.example.RCTS.cashbox;

public class CashBoxResponse {
    public CashBoxResponse(){

    }

    private String data;

    public CashBoxResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
