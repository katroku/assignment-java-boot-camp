package com.example.RCTS.cashbox;

import com.example.RCTS.address.Geo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeoRepository extends JpaRepository<Geo, Integer> {

    //this is already public
    Optional<Geo> findById(int id);
}

