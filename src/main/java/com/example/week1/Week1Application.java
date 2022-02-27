package com.example.week1;

import com.example.week1.catalogs.Catalog;
import com.example.week1.catalogs.CatalogRepository;
import com.example.week1.products.Product;
import com.example.week1.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class Week1Application {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CatalogRepository catalogRepository;

	@PostConstruct //after init all beans
	public void initializeData(){

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
				"0",
				null);

		Product product2 = new Product(
				2,
				"image2.jpg",
				"39000.00",
				"28900.00",
				"0",
				"รองเท้าผ้าใบAdidas Yeezy Boost 350 V2 'Light' Size36-45 ",
				"-28%",
				false,
				"Samut Prakan",
				"/products/2.html",
				9,
				"5.0",
				null);

		Product product3 = new Product(
				3,
				"image3.jpg",
				"1900.00",
				"399.00",
				"70",
				"ส่งเร็ว สินค้าตามภาพ รองเท้าผ้าใบAdidas NMD R1",
				"-79%",
				false,
				"Rayong",
				"/products/3.html",
				3,
				"3.5",
				null);

		//
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);

		Catalog catalog1 = new Catalog(
				1234,
				"popular",
				"Adidas NMD",
				Arrays.asList(new Product[]{product1,product2,product3}));

		catalogRepository.save(catalog1);

	}

	@PostConstruct //after init all beans
	public void initializeData2(){
		// either catalog and product cannot be found above
		//chicken and egg problem
		Catalog catalog1 = catalogRepository.findById(1234).get();
		Product product1 = productRepository.findById(1).get();
		Product product2 = productRepository.findById(2).get();
		Product product3 = productRepository.findById(3).get();

		product1.setCatalog(catalog1);
		product2.setCatalog(catalog1);
		product3.setCatalog(catalog1);

		catalog1.setProductList(Arrays.asList(new Product[]{product1,product2,product3}));

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		catalogRepository.save(catalog1);

	}



	public static void main(String[] args) {

		ConfigurableApplicationContext context =
				SpringApplication.run(Week1Application.class, args);

		int count = context.getBeanDefinitionCount();
		System.out.println(count);

	}
}
