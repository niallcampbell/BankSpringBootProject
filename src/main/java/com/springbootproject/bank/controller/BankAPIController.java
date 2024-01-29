package com.springbootproject.bank.controller;

import com.springbootproject.bank.api.BankApi;
import com.springbootproject.bank.entities.Customer;
import com.springbootproject.bank.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for the Bank API.
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class BankAPIController implements BankApi {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * GET '/customers' endpoint.
     * @return ResponseEntity containing a list of the Customer objects in the DB.
     */
    @Override
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> bankCustomers = customerRepository.findAll();
        return ResponseEntity.ok(bankCustomers);
    }

}
