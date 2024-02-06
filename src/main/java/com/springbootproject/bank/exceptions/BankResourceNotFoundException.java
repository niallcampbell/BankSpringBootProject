package com.springbootproject.bank.exceptions;

/**
 * Custom exception for when a Bank related resource is not found.
 */
public class BankResourceNotFoundException extends RuntimeException {

    public BankResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
