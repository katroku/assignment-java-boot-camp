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
import java.util.List;

@SpringBootApplication
public class RctsApplication {

	@Autowired
	private CashBoxRepository cashBoxRepository;

	@Autowired
	private GeoRepository geoRepository;

	@PostConstruct //after init all beans
	public void initializeData(){

		double[] latLong = new double[]{123.4, 123.5};
		List<CashBox> cashBoxList = null;
		Geo location = new Geo(1,latLong , cashBoxList);
		System.out.println(location.getCoordinates()[0]);
        System.out.println(location.getCoordinates()[1]);
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
