package com.example.RCTS.address;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private GeoRepository geoRepository;

    @Test
        // After a test is done, the repo is rolledback
    void findById_with_success() {
        //Arrange
        int id = 1234;
        String zipcode = "12345";
        Geo geo = new Geo(444, new double[]{444,444});
        geoRepository.save(geo);
        Address address = new Address(id, zipcode, geo);
        addressRepository.save(address);

        //Act
        //one test is one transaction
        Optional<Address> result = addressRepository.findById(1234);

        //Assert
        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        assertEquals(zipcode, result.get().getZipcode());
        assertEquals(geo.getId(), result.get().getGeo().getId());
        assertEquals(geo.getCoordinates()[0], result.get().getGeo().getCoordinates()[0]);
        assertEquals(geo.getCoordinates()[1], result.get().getGeo().getCoordinates()[1]);
    }

    @Test
    void findById_with_failure() {
        Optional<Address> result = addressRepository.findById(1234);
        assertFalse(result.isPresent());
    }

}