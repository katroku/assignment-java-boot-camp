package com.example.week1.catalogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {


    @Autowired //gets bean to use.. auto initializes object
    private CatalogService catalogService;

    @GetMapping("/catalogs/{name}")
    public CatalogResponse getCatalog(@PathVariable String name){
        return new CatalogResponse(catalogService.getCatalogData(name));

    }
}
