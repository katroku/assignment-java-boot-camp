package com.example.week1.catalogs;

import com.example.week1.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

    //this is already public
    Optional<Catalog> findById(int id);

    Optional<Catalog> findByNameLike(String name);
}

