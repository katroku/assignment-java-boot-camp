package com.example.RCTS.cashbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CashBoxService {

    @Autowired
    private CashBoxRepository cashBoxRepository;

    public void setCashBoxRepository(CashBoxRepository cashBoxRepository) {
        this.cashBoxRepository = cashBoxRepository;
    }

    public String getCashBoxData(int id){

        Optional<CashBox> result = cashBoxRepository.findById(id);

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
        throw new CashBoxNotFoundException(Integer.toString(id));
    }

    public String getAllCashBoxData() {


        List<CashBox> result = cashBoxRepository.findAll();

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