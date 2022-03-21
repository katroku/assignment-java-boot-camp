package com.example.RCTS;

import com.example.RCTS.address.Geo;
import com.example.RCTS.cashbox.*;
import com.example.RCTS.cashbox.GeoRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class RctsApplication {

	@Autowired
	private CashBoxRepository cashBoxRepository;

	@Autowired
	private GeoRepository geoRepository;

	@Autowired
	private CashBoxStatusRepository cashBoxStatusRepository;

	@PostConstruct //after init all beans
	public void initializeData(){

		double[] latLong = new double[]{123.4, 123.5};
		Geo location = new Geo(1,latLong); //don't need info about cashboxes or cashbox status
		System.out.println(location.getCoordinates()[0]);
        System.out.println(location.getCoordinates()[1]);
		geoRepository.save(location);

		CashBox cashBoxTest = new CashBox();
		cashBoxTest.setLocation(location);
		cashBoxTest.setStatusList(new ArrayList<>());
		cashBoxRepository.save(cashBoxTest);

		// Needs to have cashBox in constructor?? don;t know why
		CashBoxStatus cashBoxStatus = new CashBoxStatus(1,19991998.02, location, LocationStatus.DISPATCHED, cashBoxTest);
		cashBoxTest.updateStatus(cashBoxStatus);
		cashBoxStatusRepository.save(cashBoxStatus);

	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(RctsApplication.class, args);

		int count = context.getBeanDefinitionCount();
		System.out.println(count);
	}

}
