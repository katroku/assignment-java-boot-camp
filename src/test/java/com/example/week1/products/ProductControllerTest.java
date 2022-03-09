package com.example.week1.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //set random port number that does not clash with current running port
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate; //for testing REST API

    @Autowired //fake a repo
    private ProductRepository productRepository;

    @Test
    void case01(){
        //actually bad name
        //Arrange

        Product product = new Product(
                1,
                "image1.jpg",
                "15000.00",
                "9900.00",
                "3",
                "TOP รองเท้าAdidas NMD R1 Japan",
                "-34%",
                false,
                "Bangkok",
                "/products/1.html",
                10,
                "0",
                null);

        productRepository.save(product);
        ObjectMapper Obj = new ObjectMapper();
        String jsonString = "Object has no attributes";
        try {
            jsonString = Obj.writeValueAsString(product);
        }  catch (IOException e) {
            e.printStackTrace();
        }
//        //this is what UserService calls userRepository
//        when(productRepository.findById(555)).thenReturn(Optional.of(product));
        //Act
        //deserialize json to java POJO => done through default constructor in HelloResponse! MUST write explicitly
        ProductResponse result = testRestTemplate.getForObject("/products/1", ProductResponse.class);
        //Assert
        assertEquals(jsonString, result.getData());
    }

//    @Test
//    @DisplayName("เขียนไทยได้ Input: username = other, Expected Result: User= othernot found")
//    void testCase02(){
//        //actually bad name
//
//        //Act
//        //deserialize json to java POJO => done through default constructor in HelloResponse! MUST write explicitly
//        HelloResponse result = testRestTemplate.getForObject("/hello/other", HelloResponse.class);
//        //Assert
//        assertEquals("User= othernot found", result.getMessage());
//    }

}