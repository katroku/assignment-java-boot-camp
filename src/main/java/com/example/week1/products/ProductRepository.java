package com.example.week1.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //this is already public
    Optional<Product> findById(int id);
}

