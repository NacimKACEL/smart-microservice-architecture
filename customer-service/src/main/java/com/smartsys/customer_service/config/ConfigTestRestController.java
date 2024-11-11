package com.smartsys.customer_service.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RefreshScope
public class ConfigTestRestController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;

    @Autowired
    private CustomerConfigParams customerConfigParams;
    
    @GetMapping("testConfig1")
    public Map<String, String> configTest1() {
        return Map.of("p1", p1, "p2", p2);
    }

    @GetMapping("testConfig2")
    public CustomerConfigParams configTest2() {
        return customerConfigParams;
    }

}
