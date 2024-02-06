package com.springbootproject.bank.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class to handle API responses when custom exceptions are thrown in the code.
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Exception handler to return 404 Not Found response when a BankResourceNotFoundException
     * is thrown.
     *
     * @param ex
     * @return ResponseEntity with error details.
     */
    @ExceptionHandler(BankResourceNotFoundException.class)
    public ResponseEntity<Object> handleBankResourceNotFoundException(BankResourceNotFoundException ex) {

        BankError bankError = new BankError();
        bankError.setErrorCode(HttpStatus.NOT_FOUND.value());
        bankError.setErrorDescription(ex.getMessage());

        return new ResponseEntity<>(bankError, HttpStatus.NOT_FOUND);
    }

}
