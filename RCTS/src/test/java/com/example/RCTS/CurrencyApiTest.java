package com.example.RCTS;

import com.example.RCTS.address.Geo;
import com.example.RCTS.cashbox.*;
import com.example.RCTS.currency.Currency;
import com.example.RCTS.currency.CurrencyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //set random port number that does not clash with current running port
class CurrencyApiTest {

    @Autowired
    private TestRestTemplate testRestTemplate; //for testing REST API

    @Autowired
    private CurrencyRepository currencyRepository;

    @Test
    void api_with_success() {
        Currency currency = new Currency(1, "YEN", 3.33);
        currencyRepository.save(currency);
        Currency currency2 = new Currency(2, "USD", 0.33);
        currencyRepository.save(currency2);

        //Act
        //deserialize json to java POJO => done through default constructor in HelloResponse! MUST write explicitly
        CashBoxResponse result = testRestTemplate.getForObject("/currency/1", CashBoxResponse.class);
        //Assert
        assertEquals("{\"id\":1,\"name\":\"YEN\",\"exchangeRateToBaht\":3.33}",result.getData());
        CashBoxResponse result2 = testRestTemplate.getForObject("/currency", CashBoxResponse.class);
        //Assert
        assertEquals("[{\"id\":1,\"name\":\"YEN\",\"exchangeRateToBaht\":3.33},{\"id\":2,\"name\":\"USD\",\"exchangeRateToBaht\":0.33}]",
                result2.getData());
    }
}