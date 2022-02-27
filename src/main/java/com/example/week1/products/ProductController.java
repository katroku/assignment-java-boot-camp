package com.example.week1.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @Autowired //gets bean to use.. auto initializes object
    private ProductService productService;

    @GetMapping("/products/{id}")
    public ProductResponse getProduct(@PathVariable int id){
        return new ProductResponse(productService.getProductData(id));

    }
}
