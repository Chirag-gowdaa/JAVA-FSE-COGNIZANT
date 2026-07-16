package com.example.loanservice.service;

import com.example.loanservice.dto.LoanDto;

/**
 * Service interface defining loan-related business operations.
 */
public interface LoanService {

    /**
     * Retrieves loan details by the loan number.
     *
     * @param number the loan number to fetch
     * @return the loan DTO containing loan details
     */
    LoanDto getLoanByNumber(String number);
}
