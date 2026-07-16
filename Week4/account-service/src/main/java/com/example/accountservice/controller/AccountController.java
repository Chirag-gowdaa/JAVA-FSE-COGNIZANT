package com.example.accountservice.controller;

import com.example.accountservice.dto.AccountDto;
import com.example.accountservice.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller exposing REST endpoints for Account operations.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    // Constructor injection (Best Practice for production quality)
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Endpoint to retrieve account details by account number.
     *
     * @param number the account number
     * @return ResponseEntity holding AccountDto
     */
    @GetMapping("/{number}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable String number) {
        logger.info("Received request to fetch account with number: {}", number);
        AccountDto account = accountService.getAccountByNumber(number);
        return ResponseEntity.ok(account);
    }
}
