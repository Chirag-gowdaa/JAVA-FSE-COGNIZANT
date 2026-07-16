package com.example.greetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Bootstrap class for the Greet Service microservice.
 * Registered as a client with Eureka Server via {@link EnableDiscoveryClient}.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GreetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetServiceApplication.class, args);
    }
}
