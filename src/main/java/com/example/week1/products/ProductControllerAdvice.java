package com.example.week1.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class) //if the specified exception occurs
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND) // for 404 status
    public ProductResponse userNotFound(ProductNotFoundException e){
        //return response body
        // can design other response body other than HelloResponse

        return new ProductResponse("Product : "+e.getMessage()+ " not found");
    }
}

