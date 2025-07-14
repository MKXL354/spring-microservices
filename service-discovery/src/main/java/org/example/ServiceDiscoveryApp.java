package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Mehdi Kamali
 * @since 13/07/2025
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryApp {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApp.class, args);
    }
}
