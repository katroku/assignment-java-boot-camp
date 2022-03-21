package com.example.RCTS.cashbox;

import com.example.RCTS.address.Geo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CashBoxRepositoryTest {

    @Autowired
    private CashBoxRepository cashBoxRepository;

    @Test
    @DisplayName("input: empty object")
    void findById_with_success() {
        CashBox cashbox = new CashBox();
        cashBoxRepository.save(cashbox);
        Optional<CashBox> result = cashBoxRepository.findById(0);
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("input: none")
    void findById_with_failure() {
        Optional<CashBox> result = cashBoxRepository.findById(1234);
        assertFalse(result.isPresent());
    }

    // There's a problem with findall test
//    @Test
//    void findAll_with_success() {
//        CashBox cashBox = new CashBox();
//        cashBox.setLocation(null);
//        cashBox.setStatusList(null);
//        cashBoxRepository.save(cashBox);
//        List<CashBox> result = cashBoxRepository.findAll();
//        assertTrue(result.isEmpty());
//    }


}