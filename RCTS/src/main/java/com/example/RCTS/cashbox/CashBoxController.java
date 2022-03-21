package com.example.RCTS.cashbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashBoxController {


    @Autowired //gets bean to use.. auto initializes object
    private CashBoxService cashBoxService;

    @GetMapping("/cashbox/{id}")
    public CashBoxResponse getCashBox(@PathVariable int id){
        return new CashBoxResponse(cashBoxService.getCashBoxData(id));

    }

    @GetMapping("/cashbox")
    public CashBoxResponse getAllCashBox(){
        return new CashBoxResponse(cashBoxService.getAllCashBoxData());

    }
}
