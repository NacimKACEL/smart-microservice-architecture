package com.smartsys.billing_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.smartsys.billing_service.model.Customer;

@FeignClient(name ="customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/v1/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/api/v1/customers")
    PagedModel<Customer> getAllCustomers();
}
