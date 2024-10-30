package com.smartsys.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.smartsys.inventory_service.entities.Product;
import com.smartsys.inventory_service.repository.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(
				Product.builder()
					.name("M3 MAX")
					.price(5000.00)
					.quantity(1)
					.build()
			);
			productRepository.save(
				Product.builder()
					.name("iPhone 15")
					.price(1200.00)
					.quantity(12)
					.build()
			);
			productRepository.save(
				Product.builder()
					.name("OpenAI")
					.price(50.00)
					.quantity(3)
					.build()
			);
		};
	}

}
