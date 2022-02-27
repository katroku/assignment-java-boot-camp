package com.example.week1.catalogs;

public class CatalogNotFoundException extends RuntimeException{
    public CatalogNotFoundException(String message) {
        super(message);
    }
}

