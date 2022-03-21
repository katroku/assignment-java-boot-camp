package com.example.RCTS.currency;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    //this is already public
    Optional<Currency> findById(int id);
    List<Currency> findAll();
}

