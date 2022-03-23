package com.example.RCTS.branch;

import com.example.RCTS.address.Address;
import com.example.RCTS.address.AddressRepository;
import com.example.RCTS.address.Geo;
import com.example.RCTS.address.GeoRepository;
import com.example.RCTS.cash.Cash;
import com.example.RCTS.cash.CashRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BranchRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private GeoRepository geoRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CashRepository cashRepository;

    @Test
        // After a test is done, the repo is rolledback
    void findById_with_success() {
        //Arrange
        int id = 1234;
        String zipcode = "12345";
        String addressName = "HQ";
        Geo geo = new Geo(444, new double[]{444,444});
        geoRepository.save(geo);
        Address address = new Address(id, zipcode, geo);
        addressRepository.save(address);
        List<Cash> cashList = new ArrayList<Cash>();
        Cash cash = new Cash();
        cashRepository.save(cash);
        cashList.add(cash);
        Branch branch = new Branch(id,addressName,address, cashList);
        branchRepository.save(branch);
        //Act
        //one test is one transaction
        Optional<Branch> result = branchRepository.findById(id);

        //Assert
        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        assertEquals(addressName, result.get().getName());
    }

    @Test
    void findById_with_failure() {
        Optional<Branch> result = branchRepository.findById(1234);
        assertFalse(result.isPresent());
    }

}