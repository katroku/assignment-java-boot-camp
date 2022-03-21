package com.example.RCTS.cash;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CashRepository extends JpaRepository<Cash, Integer> {

    //this is already public
    Optional<Cash> findById(int id);
}

