package com.smartsys.billing_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartsys.billing_service.entities.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
