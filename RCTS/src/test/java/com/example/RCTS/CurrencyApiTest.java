package com.example.RCTS;

import com.example.RCTS.currency.Currency;
import com.example.RCTS.currency.CurrencyRepository;
import com.example.RCTS.currency.CurrencyResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.transaction.annotation.Transactional;

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
        currency.setCashList(new ArrayList<>());
        currencyRepository.save(currency);
        Currency currency2 = new Currency(2, "USD", 0.33);
        currency2.setCashList(new ArrayList<>());
        currencyRepository.save(currency2);

        //Act
        //deserialize json to java POJO => done through default constructor in HelloResponse! MUST write explicitly
        CurrencyResponse result = testRestTemplate.getForObject("/currency/1", CurrencyResponse.class);
        //Assert
        assertEquals("{\"id\":1,\"name\":\"YEN\",\"exchangeRateToBaht\":3.33}"
                ,result.getData());
        CurrencyResponse result2 = testRestTemplate.getForObject("/currency", CurrencyResponse.class);
        //Assert
        assertEquals("[{\"id\":1,\"name\":\"YEN\",\"exchangeRateToBaht\":3.33},{\"id\":2,\"name\":\"USD\",\"exchangeRateToBaht\":0.33}]"
                ,result2.getData());

        currency2.setName("SPX");
        assertEquals("SPX",currency2.getName());
        testRestTemplate.postForObject("/currency/2", currency2,CurrencyResponse.class);
        CurrencyResponse result3 = testRestTemplate.getForObject("/currency", CurrencyResponse.class);
        //There was a problem where currency wasn't updated .. i think because of my Jackson declaration
        assertEquals("[{\"id\":1,\"name\":\"YEN\",\"exchangeRateToBaht\":3.33},{\"id\":2,\"name\":\"SPX\",\"exchangeRateToBaht\":0.33}]"
                ,result3.getData());
    }
}