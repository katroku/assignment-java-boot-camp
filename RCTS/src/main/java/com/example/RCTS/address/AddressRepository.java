package com.example.RCTS.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    //this is already public
    Optional<Address> findById(int id);
}
