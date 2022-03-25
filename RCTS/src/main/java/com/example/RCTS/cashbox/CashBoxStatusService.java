package com.example.RCTS.cashbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CashBoxStatusService {

    @Autowired
    private CashBoxStatusRepository cashBoxStatusRepository;

    public void setCashBoxStatusRepository(CashBoxStatusRepository cashBoxStatusRepository) {
        this.cashBoxStatusRepository = cashBoxStatusRepository;
    }

    public String getCashBoxStatusData(int id){

        Optional<CashBoxStatus> result = cashBoxStatusRepository.findById(id);

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
        throw new CashBoxStatusNotFoundException(Integer.toString(id));
    }

    public String getAllCashBoxStatusData() {


        List<CashBoxStatus> result = cashBoxStatusRepository.findAll();

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