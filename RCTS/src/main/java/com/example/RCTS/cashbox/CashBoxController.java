package com.example.RCTS.cashbox;

import com.example.RCTS.address.Geo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/cashbox/{id}/status")
    public CashBoxStatus updateCashBoxStatus(@RequestBody CashBoxStatus newCashBoxStatus, @PathVariable int id) {
        return cashBoxRepository.findById(id)
                .map(cashBox -> {
                    cashBox.updateStatus(newCashBoxStatus);
                    cashBoxRepository.save(cashBox);
                    return newCashBoxStatus;
                }).orElseGet(() -> {
                    return newCashBoxStatus;
                });
    }

    @PostMapping("/cashbox/{id}/location")
    public Geo updateCashBoxLocation(@RequestBody Geo newGeo, @PathVariable int id) {
        return cashBoxRepository.findById(id)
                .map(cashBox -> {
                    cashBox.setLocation(newGeo);
                    cashBoxRepository.save(cashBox);
                    return newGeo;
                }).orElseGet(() -> {
                    return newGeo;
                });
    }


}
