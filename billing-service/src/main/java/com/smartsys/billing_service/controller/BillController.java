package com.smartsys.billing_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smartsys.billing_service.entities.Bill;
import com.smartsys.billing_service.feign.CustomerRestClient;
import com.smartsys.billing_service.feign.ProductRestClient;
import com.smartsys.billing_service.repository.BillRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;
    
    @GetMapping("bills/{id}")
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;   
    }
}
