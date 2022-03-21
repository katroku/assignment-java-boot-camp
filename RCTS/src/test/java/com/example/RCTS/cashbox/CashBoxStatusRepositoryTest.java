package com.example.RCTS.cashbox;

import com.example.RCTS.address.Geo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CashBoxStatusRepositoryTest {

    @Autowired
    private CashBoxStatusRepository cashBoxStatusRepository;

    @Test
    @DisplayName("input: CashBoxStatus with fields")
    void findById_with_success01() {
        Geo location = null;
        CashBox cashBoxTest = null;
        CashBoxStatus cashBoxStatus = new CashBoxStatus(1,19991998.02, location, LocationStatus.DISPATCHED, cashBoxTest);
        cashBoxStatusRepository.save(cashBoxStatus);
        Optional<CashBoxStatus> result = cashBoxStatusRepository.findById(1);
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("input: empty CashBoxStatus Object")
    void findById_with_success02() {
        CashBoxStatus cashBoxStatus = new CashBoxStatus();
        cashBoxStatusRepository.save(cashBoxStatus);
        Optional<CashBoxStatus> result = cashBoxStatusRepository.findById(0);
        assertTrue(result.isPresent());
    }

    @Test
    void findById_with_failure() {
        Optional<CashBoxStatus> result = cashBoxStatusRepository.findById(1234);
        assertFalse(result.isPresent());
    }
}