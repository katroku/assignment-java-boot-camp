package com.example.RCTS.cashbox;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CashBoxStatusRepository extends JpaRepository<CashBoxStatus, Integer> {

    //this is already public
    Optional<CashBoxStatus> findById(int id);
}

