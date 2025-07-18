package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Mehdi Kamali
 * @since 14/07/2025
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrganizationServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServiceApp.class, args);
    }
}
