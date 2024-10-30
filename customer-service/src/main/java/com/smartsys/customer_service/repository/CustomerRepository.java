package com.smartsys.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.smartsys.customer_service.entities.Customer;

@RepositoryRestController
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
