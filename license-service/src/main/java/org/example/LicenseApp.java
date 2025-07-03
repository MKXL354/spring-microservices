package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Mehdi Kamali
 * @since 15/06/2025
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LicenseApp {

    public static void main(String[] args) {
        SpringApplication.run(LicenseApp.class, args);
    }
}
