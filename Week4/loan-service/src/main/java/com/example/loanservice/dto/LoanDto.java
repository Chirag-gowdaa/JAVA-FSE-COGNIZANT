package com.example.loanservice.dto;

/**
 * Data Transfer Object (DTO) representing loan details.
 * Implemented using pure Java to eliminate compilation dependencies on Lombok.
 */
public class LoanDto {

    private String number;
    private String type;
    private double loan;
    private double emi;
    private int tenure;

    // Default constructor
    public LoanDto() {
    }

    // All-args constructor
    public LoanDto(String number, String type, double loan, double emi, int tenure) {
        this.number = number;
        this.type = type;
        this.loan = loan;
        this.emi = emi;
        this.tenure = tenure;
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

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    // Builder Pattern implementation for compatibility with existing service classes
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String number;
        private String type;
        private double loan;
        private double emi;
        private int tenure;

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder loan(double loan) {
            this.loan = loan;
            return this;
        }

        public Builder emi(double emi) {
            this.emi = emi;
            return this;
        }

        public Builder tenure(int tenure) {
            this.tenure = tenure;
            return this;
        }

        public LoanDto build() {
            return new LoanDto(number, type, loan, emi, tenure);
        }
    }
}
