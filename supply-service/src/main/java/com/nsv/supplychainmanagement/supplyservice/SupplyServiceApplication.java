package com.nsv.supplychainmanagement.supplyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class SupplyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplyServiceApplication.class, args);
    }

}
