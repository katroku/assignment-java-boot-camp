package com.example.RCTS;

import com.example.RCTS.address.Geo;
import com.example.RCTS.cashbox.CashBox;
import com.example.RCTS.cashbox.CashBoxRepository;
import com.example.RCTS.cashbox.GeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RctsApplication {

	@Autowired
	private CashBoxRepository cashBoxRepository;

	@Autowired
	private GeoRepository geoRepository;

	@PostConstruct //after init all beans
	public void initializeData(){

		Geo location = new Geo();
		geoRepository.save(location);
		CashBox cashBoxTest = new CashBox();
		cashBoxTest.setLocation(location);
		cashBoxRepository.save(cashBoxTest);

	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(RctsApplication.class, args);

		int count = context.getBeanDefinitionCount();
		System.out.println(count);
	}

}
