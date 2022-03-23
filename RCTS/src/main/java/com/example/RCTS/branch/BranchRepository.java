package com.example.RCTS.branch;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

    //this is already public
    Optional<Branch> findById(int id);
}

