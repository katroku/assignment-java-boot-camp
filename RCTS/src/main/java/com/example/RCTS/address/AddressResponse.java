package com.example.RCTS.address;

public class AddressResponse {
    public AddressResponse(){

    }

    private String data;

    public AddressResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
