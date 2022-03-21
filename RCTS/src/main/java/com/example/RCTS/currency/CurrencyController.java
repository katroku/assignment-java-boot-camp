package com.example.RCTS.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {


    @Autowired //gets bean to use.. auto initializes object
    private CurrencyService currencyService;

    @GetMapping("/currency/{id}")
    public CurrencyResponse getCurrency(@PathVariable int id){
        return new CurrencyResponse(currencyService.getCurrencyData(id));

    }

    @GetMapping("/currency")
    public CurrencyResponse getAllCurrency(){
        return new CurrencyResponse(currencyService.getAllCurrencyData());

    }
}
