package com.example.RCTS.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public void setCurrencyRepository(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public String getCurrencyData(int id){

        Optional<Currency> result = currencyRepository.findById(id);

        if(result.isPresent()){
            ObjectMapper Obj = new ObjectMapper();
            String jsonString = "Object has no attributes";
            try {
                jsonString = Obj.writeValueAsString(result.get());
            }
            catch (IOException e) {
                // e.printStackTrace();
                // To change
            }
            return jsonString;
        }
        //converts to String before passing as a message
        throw new CurrencyNotFoundException(Integer.toString(id));
    }


    public String getAllCurrencyData() {

        List<Currency> result = currencyRepository.findAll();

        ObjectMapper Obj = new ObjectMapper();
        String jsonString = "Object has no attributes";
        try {
            jsonString = Obj.writeValueAsString(result);
        }
        catch (IOException e) {
            // e.printStackTrace();
            // To change
        }
        return jsonString;
    }
}