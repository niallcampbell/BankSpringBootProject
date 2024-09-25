package com.springbootproject.bank.exceptions;

/**
 * Custom exception for bad requests.
 */
public class BankBadRequestException extends RuntimeException {

    public BankBadRequestException(String errorMessage) {
        super(errorMessage);
    }

}
