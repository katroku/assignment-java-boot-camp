package com.example.RCTS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RctsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(RctsApplication.class, args);

		int count = context.getBeanDefinitionCount();
		System.out.println(count);
	}

}
