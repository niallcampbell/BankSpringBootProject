package com.springbootproject.bank.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class APIExceptionHandlerTest {

    // InjectMocks creates an instance of the exception handler for us.
    @InjectMocks
    private APIExceptionHandler apiExceptionHandler;

    @Test
    public void handleBankResourceNotFoundExceptionTest() {

        BankResourceNotFoundException ex = new BankResourceNotFoundException("Bank Account not found for id: 123");

        ResponseEntity<Object> responseEntity = apiExceptionHandler.handleBankResourceNotFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode().value());
    }

}
