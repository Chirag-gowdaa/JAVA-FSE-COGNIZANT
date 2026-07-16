package com.example.greetservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller exposing REST endpoints for Greet operations.
 */
@RestController
public class GreetController {

    private static final Logger logger = LoggerFactory.getLogger(GreetController.class);

    /**
     * Endpoint to retrieve a greeting.
     *
     * @return ResponseEntity holding a greeting string
     */
    @GetMapping("/greet")
    public ResponseEntity<String> getGreeting() {
        logger.info("Received request to fetch greeting");
        return ResponseEntity.ok("Hello World");
    }
}
