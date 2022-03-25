package com.example.RCTS.cash;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CashService {

    @Autowired
    private CashRepository cashRepository;

    public void setCashRepository(CashRepository cashRepository) {
        this.cashRepository = cashRepository;
    }

    public String getCashData(int id){

        Optional<Cash> result = cashRepository.findById(id);

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
        throw new CashNotFoundException(Integer.toString(id));
    }

    public String getAllCashData() {


        List<Cash> result = cashRepository.findAll();

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