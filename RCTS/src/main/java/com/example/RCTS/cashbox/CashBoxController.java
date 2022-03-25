package com.example.RCTS.cashbox;

import com.example.RCTS.currency.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CashBoxController {


    @Autowired //gets bean to use.. auto initializes object
    private CashBoxService cashBoxService;

    @Autowired //gets bean to use.. auto initializes object
    private CashBoxRepository cashBoxRepository;

    @GetMapping("/cashbox/{id}")
    public CashBoxResponse getCashBox(@PathVariable int id){
        return new CashBoxResponse(cashBoxService.getCashBoxData(id));

    }

    @GetMapping("/cashbox")
    public CashBoxResponse getAllCashBox(){
        return new CashBoxResponse(cashBoxService.getAllCashBoxData());

    }

    @PostMapping("/cashbox/{id}")
    public CashBox updateCashBox(@RequestBody CashBox newCashBox, @PathVariable int id) {
        return cashBoxRepository.save(newCashBox);
    }

}
