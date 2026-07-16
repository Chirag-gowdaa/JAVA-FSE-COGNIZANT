package com.example.accountservice.dto;

/**
 * Data Transfer Object (DTO) representing account details.
 * Implemented using pure Java to eliminate compilation dependencies on Lombok.
 */
public class AccountDto {

    private String number;
    private String type;
    private double balance;

    // Default constructor
    public AccountDto() {
    }

    // All-args constructor
    public AccountDto(String number, String type, double balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    // Getters and Setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Builder Pattern implementation for compatibility with existing service classes
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String number;
        private String type;
        private double balance;

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public AccountDto build() {
            return new AccountDto(number, type, balance);
        }
    }
}
