package com.example.RCTS.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class GeoService {

    @Autowired
    private GeoRepository geoRepository;

    public void setGeoRepository(GeoRepository geoRepository) {
        this.geoRepository = geoRepository;
    }

    public String getGeoData(int id){

        Optional<Geo> result = geoRepository.findById(id);

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
        throw new GeoNotFoundException(Integer.toString(id));
    }

    public String getAllGeoData() {


        List<Geo> result = geoRepository.findAll();

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