package com.example.RCTS;

import com.example.RCTS.address.Geo;
import com.example.RCTS.cashbox.*;
import com.example.RCTS.cashbox.GeoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //set random port number that does not clash with current running port
class CashBoxApiTest {

    @Autowired
    private TestRestTemplate testRestTemplate; //for testing REST API
    
    @Autowired
    private GeoRepository geoRepository;

    @Autowired
    private CashBoxRepository cashBoxRepository;

    @Autowired
    private CashBoxStatusRepository cashBoxStatusRepository;

    @Test
    void api_with_success() {

        double[] latLong = new double[]{123.4, 123.5};
        Geo location = new Geo(1,latLong); //don't need info about cashboxes or cashbox status
        geoRepository.save(location);

        CashBox cashBoxTest = new CashBox();
        cashBoxTest.setLocation(location);
        cashBoxTest.setStatusList(new ArrayList<>());
        cashBoxRepository.save(cashBoxTest);

        // Needs to have cashBox in constructor?? don;t know why
        CashBoxStatus cashBoxStatus = new CashBoxStatus(1,19991998.02, location, LocationStatus.DISPATCHED, cashBoxTest);
        cashBoxTest.updateStatus(cashBoxStatus);
        cashBoxStatusRepository.save(cashBoxStatus);

        //Act
        //deserialize json to java POJO => done through default constructor in HelloResponse! MUST write explicitly
        CashBoxResponse result = testRestTemplate.getForObject("/cashbox/0", CashBoxResponse.class);
        //Assert
        assertEquals("{\"id\":0,\"location\":{\"id\":1,\"coordinates\":[123.4,123.5]},\"statusList\":[{\"timestamp\":1.999199802E7,\"location\":{\"id\":1,\"coordinates\":[123.4,123.5]},\"locationStatus\":\"DISPATCHED\"}],\"timeCreated\":0}",
                result.getData());
        CashBoxResponse result2 = testRestTemplate.getForObject("/cashbox", CashBoxResponse.class);
        //Assert
        assertEquals("[{\"id\":0,\"location\":{\"id\":1,\"coordinates\":[123.4,123.5]},\"statusList\":[{\"timestamp\":1.999199802E7,\"location\":{\"id\":1,\"coordinates\":[123.4,123.5]},\"locationStatus\":\"DISPATCHED\"}],\"timeCreated\":0}]",
                result2.getData());
    }
}