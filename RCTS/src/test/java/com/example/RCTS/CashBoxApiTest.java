package com.example.RCTS;

import com.example.RCTS.address.Geo;
import com.example.RCTS.address.GeoRepository;
import com.example.RCTS.branch.Branch;
import com.example.RCTS.branch.BranchRepository;
import com.example.RCTS.cash.Cash;
import com.example.RCTS.cash.CashRepository;
import com.example.RCTS.cashbox.*;
import com.example.RCTS.currency.Currency;
import com.example.RCTS.currency.CurrencyRepository;
import org.h2.store.FileLock;
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

    @Autowired
    private CashRepository cashRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Test
    void api_with_success() {

        double[] latLong = new double[]{123.4, 123.5};
        Geo location = new Geo(1,latLong); //don't need info about cashboxes or cashbox status
        geoRepository.save(location);

        Branch sender = new Branch(); //don't need info about cashboxes or cashbox status
        sender.setId(1);
        branchRepository.save(sender);

        Branch recipient = new Branch(); //don't need info about cashboxes or cashbox status
        recipient.setId(2);
        branchRepository.save(recipient);

        CashBox cashBoxTest = new CashBox();
        cashBoxTest.setLocation(location);
        cashBoxTest.setStatusList(new ArrayList<>());
        cashBoxTest.setCashList(new ArrayList<>());
        cashBoxTest.setSender(sender);
        cashBoxTest.setRecipient(recipient);
        cashBoxRepository.save(cashBoxTest);

        // Needs to have cashBox in constructor?? don;t know why
        CashBoxStatus cashBoxStatus = new CashBoxStatus(1,19991998.02, location, LocationStatus.DISPATCHED, cashBoxTest);
        cashBoxTest.updateStatus(cashBoxStatus);
        cashBoxStatusRepository.save(cashBoxStatus);

        //save currency so cash can reference
        Currency currency = new Currency(444, "DOGE", 3000.33);
        currencyRepository.save(currency);
        Cash cash = new Cash(1,currency,3000);
        cash.setCashBox(cashBoxTest);
        cashBoxTest.updateCashList(cash); // requires addition of cashbox in cash so that the tables can join properly
        cashRepository.save(cash);

        //Act
        //deserialize json to java POJO => done through default constructor in HelloResponse! MUST write explicitly
        CashBoxResponse result = testRestTemplate.getForObject("/cashbox/0", CashBoxResponse.class);
        //Assert
        assertEquals("{\"id\":0,\"cashList\":[{\"id\":1,\"currency\":{\"id\":444,\"name\":\"DOGE\",\"exchangeRateToBaht\":3000.33},\"amount\":3000.0}],\"sender\":{\"id\":1,\"name\":null,\"address\":null,\"totalCashAtBranch\":[]},\"recipient\":{\"id\":2,\"name\":null,\"address\":null,\"totalCashAtBranch\":[]},\"location\":{\"id\":1,\"coordinates\":[123.4,123.5]},\"statusList\":[{\"timestamp\":1.999199802E7,\"location\":1,\"locationStatus\":\"DISPATCHED\"}],\"timeCreated\":0}"
                ,result.getData());
        CashBoxResponse result2 = testRestTemplate.getForObject("/cashbox", CashBoxResponse.class);
        //Assert
        assertEquals("[{\"id\":0,\"cashList\":[{\"id\":1,\"currency\":{\"id\":444,\"name\":\"DOGE\",\"exchangeRateToBaht\":3000.33},\"amount\":3000.0}],\"sender\":{\"id\":1,\"name\":null,\"address\":null,\"totalCashAtBranch\":[]},\"recipient\":{\"id\":2,\"name\":null,\"address\":null,\"totalCashAtBranch\":[]},\"location\":{\"id\":1,\"coordinates\":[123.4,123.5]},\"statusList\":[{\"timestamp\":1.999199802E7,\"location\":1,\"locationStatus\":\"DISPATCHED\"}],\"timeCreated\":0}]"
                ,result2.getData());
    }
}