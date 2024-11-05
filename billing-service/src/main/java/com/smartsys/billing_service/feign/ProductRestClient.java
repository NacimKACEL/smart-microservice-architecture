package com.smartsys.billing_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.smartsys.billing_service.model.Product;

@FeignClient(name ="inventory-service")
public interface ProductRestClient {

    @GetMapping("/api/v1/products/{id}")
    Product getProductById(@PathVariable Long id);

    @GetMapping("/api/v1/products")
    PagedModel<Product> getAllProducts();
}
