package com.example.week1;

import com.example.week1.products.Product;
import com.example.week1.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Week1Application {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct //after init all beans
	public void initializeProductData(){
		// this is a test
		// save data into table User in database

		Product product1 = new Product(
				1,
				"image1.jpg",
				"15000.00",
				"9900.00",
				"3",
				"TOP รองเท้าAdidas NMD R1 Japan",
				"-34%",
				false,
				"Bangkok",
				"/products/1.html",
				10,
				"0");
		productRepository.save(product1);
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
				SpringApplication.run(Week1Application.class, args);

		int count = context.getBeanDefinitionCount();
		System.out.println(count);

	}
}
