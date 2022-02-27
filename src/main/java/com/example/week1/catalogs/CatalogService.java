package com.example.week1.catalogs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public String getCatalogData(String name) {

        Optional<Catalog> result = catalogRepository.findByNameLike(name);

        if(result.isPresent()){
            ObjectMapper Obj = new ObjectMapper();
            String jsonString = "Object has no attributes";
            try {
                jsonString = Obj.writeValueAsString(result.get());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return jsonString;
        }
        //converts to String before passing as a message
        throw new CatalogNotFoundException(name);
    }

}