package com.example.week1.products;

public class ProductResponse {
    public ProductResponse(){

    }

    private String data;

    public ProductResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
