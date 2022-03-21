package com.example.RCTS.address;

import com.example.RCTS.cashbox.GeoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GeoRepositoryTest {

    @Autowired
    private GeoRepository geoRepository;

    @Test
        // After a test is done, the repo is rolledback
    void findById_with_success() {
        //Arrange
        Geo geo = new Geo();
        geo.setId(1234);
        double[] coordinates = new double[]{12.34,12.34};
        geo.setCoordinates(coordinates);
        geoRepository.save(geo);

        //Act
        //one test is one transaction
        Optional<Geo> result = geoRepository.findById(1234);

        //Assert
        assertTrue(result.isPresent());
        assertEquals(1234, result.get().getId());
        assertEquals(coordinates[0], result.get().getCoordinates()[0]);
        assertEquals(coordinates[1], result.get().getCoordinates()[1]);
    }

    @Test
    void findById_with_failure() {
        Optional<Geo> result = geoRepository.findById(1234);
        assertFalse(result.isPresent());
    }

}