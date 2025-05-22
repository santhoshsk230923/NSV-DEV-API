package com.nsv.supplychainmanagement.factoryprocessingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class FactoryProcessingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryProcessingServiceApplication.class, args);
    }

}
