package com.springbootproject.bank.exceptions;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class to handle API responses when custom exceptions are thrown in the code.
 *
 * Extends the ResponseEntityExceptionHandler abstract class so that we can provide custom
 * handling for certain API exceptions that are thrown implicitly by Swagger.
 *
 * To find what response exception is thrown by Spring Boot, add a breakpoint to the
 * ResponseEntityExceptionHandler class and debug through it to see what handler method
 * is ultimately called. Then override this method with your custom logic.
 *
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Exception handler to return 404 Not Found response when a BankResourceNotFoundException
     * is thrown.
     *
     * @param ex
     * @return ResponseEntity with 404 error details.
     */
    @ExceptionHandler(BankResourceNotFoundException.class)
    public ResponseEntity<Object> handleBankResourceNotFoundException(BankResourceNotFoundException ex) {

        BankError bankError = new BankError();
        bankError.setErrorCode(HttpStatus.NOT_FOUND.value());
        bankError.setErrorDescription(ex.getMessage());

        return new ResponseEntity<>(bankError, HttpStatus.NOT_FOUND);
    }

    /**
     * Exception handler to return 400 Bad Request response when a BankBadRequestException
     * is thrown.
     *
     * @param ex
     * @return ResponseEntity with 400 error details.
     */
    @ExceptionHandler(BankBadRequestException.class)
    public ResponseEntity<Object> handleBankBadRequestException(BankBadRequestException ex) {

        BankError bankError = new BankError();
        bankError.setErrorCode(HttpStatus.BAD_REQUEST.value());
        bankError.setErrorDescription(ex.getMessage());

        return new ResponseEntity<>(bankError, HttpStatus.BAD_REQUEST);
    }

    /**
     * Override handleTypeMismatch exception handler method in ResponseEntityExceptionHandler.
     *
     * This exception is normally handled implicitly by Spring Boot / Swagger.
     * However, we can override it if we want to perform our own behaviour.
     *
     * Handles the scenario where an invalid data type is provided as a path parameter,
     * e.g. path parameter expects an Integer 123 but is provided a String "test".
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return ResponseEntity with 400 error details.
     */
    @Override
    public ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
                                                     HttpStatus status, WebRequest request) {

        BankError bankError = new BankError();
        bankError.setErrorCode(HttpStatus.BAD_REQUEST.value());
        bankError.setErrorDescription("Wrong type provided in path variable. Exception: " + ex.getMessage());

        return new ResponseEntity<>(bankError, HttpStatus.BAD_REQUEST);
    }

    /**
     * Override handleHttpMessageNotReadable exception handler method in ResponseEntityExceptionHandler.
     *
     * Handles the scenario where an invalid data type is provided in the request body,
     * e.g. a field in the request body expects an Integer 123 but is provided a String "test".
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return ResponseEntity with 400 error details.
     */
    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {

        BankError bankError = new BankError();
        bankError.setErrorCode(HttpStatus.BAD_REQUEST.value());
        bankError.setErrorDescription("Wrong type provided in request body. Exception: " + ex.getMessage());

        return new ResponseEntity<>(bankError, HttpStatus.BAD_REQUEST);
    }

}
