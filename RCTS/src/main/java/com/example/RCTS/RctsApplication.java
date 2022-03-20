package com.example.RCTS;

import com.example.RCTS.cashbox.CashBox;
import com.example.RCTS.cashbox.CashBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RctsApplication {

	@Autowired
	private CashBoxRepository cashBoxRepository;

	@PostConstruct //after init all beans
	public void initializeData(){

		CashBox cashBoxTest = new CashBox();
		cashBoxRepository.save(cashBoxTest);

	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(RctsApplication.class, args);

		int count = context.getBeanDefinitionCount();
		System.out.println(count);
	}

}
