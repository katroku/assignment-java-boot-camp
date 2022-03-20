package com.example.RCTS.cashbox;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CashBoxControllerAdvice {

    @ExceptionHandler(CashBoxNotFoundException.class) //if the specified exception occurs
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND) // for 404 status
    public CashBoxResponse userNotFound(CashBoxNotFoundException e){
        //return response body
        // can design other response body other than HelloResponse

        return new CashBoxResponse("CashBox : "+e.getMessage()+ " not found");
    }
}

