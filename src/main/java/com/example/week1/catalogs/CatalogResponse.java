package com.example.week1.catalogs;

public class CatalogResponse {
    public CatalogResponse(){

    }

    private String data;

    public CatalogResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
