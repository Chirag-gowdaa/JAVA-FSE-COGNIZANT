package com.example.accountservice.service;

import com.example.accountservice.dto.AccountDto;

/**
 * Service interface defining account-related business operations.
 */
public interface AccountService {

    /**
     * Retrieves account details by the account number.
     *
     * @param number the account number to fetch
     * @return the account DTO containing account details
     */
    AccountDto getAccountByNumber(String number);
}
