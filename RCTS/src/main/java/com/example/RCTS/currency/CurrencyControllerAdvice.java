package com.example.RCTS.currency;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CurrencyControllerAdvice {

    @ExceptionHandler(CurrencyNotFoundException.class) //if the specified exception occurs
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND) // for 404 status
    public CurrencyResponse userNotFound(CurrencyNotFoundException e){
        //return response body
        // can design other response body other than HelloResponse

        return new CurrencyResponse("Currency : "+e.getMessage()+ " not found");
    }
}

