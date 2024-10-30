package com.smartsys.customer_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.smartsys.customer_service.entities.Customer;
import com.smartsys.customer_service.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(
				Customer.builder()
					.name("Nacim")
					.email("nacim@gmail.com")
					.build()
			);
			customerRepository.save(
				Customer.builder()
					.name("James")
					.email("james@gmail.com")
					.build()
			);
			customerRepository.save(
				Customer.builder()
					.name("Rose")
					.email("rose@gmail.com")
					.build()
			);
		};
	}

}
