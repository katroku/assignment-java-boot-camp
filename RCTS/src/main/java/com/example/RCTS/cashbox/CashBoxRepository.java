package com.example.RCTS.cashbox;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CashBoxRepository extends JpaRepository<CashBox, Integer> {

    //this is already public
    Optional<CashBox> findById(int id);
    List<CashBox> findAll();
}

