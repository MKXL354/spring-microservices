package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Mehdi Kamali
 * @since 15/06/2025
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LicenseServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(LicenseServiceApp.class, args);
    }
}
