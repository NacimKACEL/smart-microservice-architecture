package com.smartsys.billing_service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.smartsys.billing_service.entities.Bill;
import com.smartsys.billing_service.entities.ProductItem;
import com.smartsys.billing_service.feign.CustomerRestClient;
import com.smartsys.billing_service.feign.ProductRestClient;
import com.smartsys.billing_service.model.Customer;
import com.smartsys.billing_service.model.Product;
import com.smartsys.billing_service.repository.BillRepository;
import com.smartsys.billing_service.repository.ProductItemRepository;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
		BillRepository billRepository,
		ProductItemRepository productItemRepository,
		ProductRestClient productRestClient,
		CustomerRestClient customerRestClient
	) {
		return args -> {
			Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
			Collection<Product> products = productRestClient.getAllProducts().getContent();
			
			customers.forEach( customer -> {
				
				Bill bill = Bill.builder()
					.bellingDate(LocalDate.now())
					.customerId(customer.getId())
					.build();
				billRepository.save(bill);
				
				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder()
						.bill(bill)
						.productId(product.getId())
						.quantity(1 + new Random().nextInt(10))
						.unitPrice(product.getPrice())
						.build();
					productItemRepository.save(productItem);
				});
			});		
		};
	}

}
