package com.springbootproject.bank.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class APIExceptionHandlerTest {

    @Mock
    HttpHeaders httpHeaders;

    @Mock
    WebRequest webRequest;

    @Mock
    TypeMismatchException typeMismatchException;

    @Mock
    HttpMessageNotReadableException httpMessageNotReadableException;

    // InjectMocks creates an instance of the exception handler for us and injects the mocks into it. .
    @InjectMocks
    private APIExceptionHandler apiExceptionHandler;

    @Test
    public void handleBankResourceNotFoundExceptionTest() {

        BankResourceNotFoundException ex = new BankResourceNotFoundException("Bank Account not found for id: 123");

        ResponseEntity<Object> responseEntity = apiExceptionHandler.handleBankResourceNotFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode().value());
    }

    @Test
    public void handleBankBadRequestExceptionTest() {

        BankBadRequestException ex = new BankBadRequestException("Request body is empty");

        ResponseEntity<Object> responseEntity = apiExceptionHandler.handleBankBadRequestException(ex);

        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCode().value());
    }

    @Test
    public void handleTypeMismatchTest() {

        ResponseEntity<Object> response = apiExceptionHandler.handleTypeMismatch(typeMismatchException,
                httpHeaders, HttpStatus.BAD_REQUEST, webRequest);

        BankError error = (BankError) response.getBody();

        assertEquals(HttpStatus.BAD_REQUEST.value(), error.getErrorCode());
    }

    @Test
    public void handleHttpMessageNotReadableTest() {

        ResponseEntity<Object> response = apiExceptionHandler.handleHttpMessageNotReadable(httpMessageNotReadableException,
                httpHeaders, HttpStatus.BAD_REQUEST, webRequest);

        BankError error = (BankError) response.getBody();

        assertEquals(HttpStatus.BAD_REQUEST.value(), error.getErrorCode());
    }

}
