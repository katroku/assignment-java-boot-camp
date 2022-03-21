package com.example.RCTS.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {


    @Autowired //gets bean to use.. auto initializes object
    private CurrencyService currencyService;

    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/currency/{id}")
    public CurrencyResponse getCurrency(@PathVariable int id){
        return new CurrencyResponse(currencyService.getCurrencyData(id));

    }

    @GetMapping("/currency")
    public CurrencyResponse getAllCurrency(){
        return new CurrencyResponse(currencyService.getAllCurrencyData());

    }

    @PostMapping("/currency/{id}")
    public Currency updateCurrency(@RequestBody Currency newCurrency, @PathVariable int id) {
//        return currencyRepository.save(newCurrency);
        return currencyRepository.findById(id)
                .map(currency -> {
                    currency.setName(newCurrency.getName());
                    currency.setExchangeRateToBaht(newCurrency.getExchangeRateToBaht());
                    return currencyRepository.save(currency);
                })
                .orElseGet(() -> {
                    return currencyRepository.save(newCurrency);
                });
    }
}
