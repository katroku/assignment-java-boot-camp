package com.example.RCTS.address;

public class GeoResponse {
    public GeoResponse(){

    }

    private String data;

    public GeoResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
