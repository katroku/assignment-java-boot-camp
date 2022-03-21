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


	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(RctsApplication.class, args);

		int count = context.getBeanDefinitionCount();
		System.out.println(count);
	}

}
