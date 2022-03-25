package com.example.RCTS.cashbox;

public class CashBoxStatusResponse {
    public CashBoxStatusResponse(){

    }

    private String data;

    public CashBoxStatusResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
