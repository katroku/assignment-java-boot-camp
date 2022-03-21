package com.example.RCTS.currency;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CurrencyRepositoryTest {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Test
    @DisplayName("Success Case, input: empty Currency object")
    void findById_with_success01() {
        Currency currency = new Currency();
        currencyRepository.save(currency);
        Optional<Currency> result = currencyRepository.findById(0);
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("Success Case, input: Currency object")
    void findById_with_success02() {
        Currency currency = new Currency(1, "YEN", 3.33);
        currencyRepository.save(currency);
        Optional<Currency> result = currencyRepository.findById(1);
        assertTrue(result.isPresent());
    }

    @Test
    void findAll_with_success() {
        Currency currency = new Currency(1, "YEN", 3.33);
        currencyRepository.save(currency);
        Currency currency2 = new Currency(2, "USD", 0.33);
        currencyRepository.save(currency2);
        List<Currency> result = currencyRepository.findAll();
        assertEquals(2,result.size());
    }
}