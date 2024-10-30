package com.smartsys.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.smartsys.inventory_service.entities.Product;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product, Long>{

}
