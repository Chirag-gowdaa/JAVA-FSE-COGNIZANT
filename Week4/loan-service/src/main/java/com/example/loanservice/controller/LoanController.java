package com.example.loanservice.controller;

import com.example.loanservice.dto.LoanDto;
import com.example.loanservice.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller exposing REST endpoints for Loan operations.
 */
@RestController
@RequestMapping("/loans")
public class LoanController {

    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
    private final LoanService loanService;

    // Constructor injection (Best Practice for production quality)
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    /**
     * Endpoint to retrieve loan details by loan number.
     *
     * @param number the loan number
     * @return ResponseEntity holding LoanDto
     */
    @GetMapping("/{number}")
    public ResponseEntity<LoanDto> getLoan(@PathVariable String number) {
        logger.info("Received request to fetch loan with number: {}", number);
        LoanDto loan = loanService.getLoanByNumber(number);
        return ResponseEntity.ok(loan);
    }
}
