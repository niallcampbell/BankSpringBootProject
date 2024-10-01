package com.springbootproject.bank.controller;

import com.springbootproject.bank.api.BankApi;
import com.springbootproject.bank.entities.BankAccount;
import com.springbootproject.bank.entities.Customer;
import com.springbootproject.bank.exceptions.BankBadRequestException;
import com.springbootproject.bank.exceptions.BankResourceNotFoundException;
import com.springbootproject.bank.model.AddCustomerModel;
import com.springbootproject.bank.repo.BankAccountRepository;
import com.springbootproject.bank.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    BankAccountRepository bankAccountRepository;

    /**
     * GET '/customers' endpoint.
     * @return ResponseEntity containing a list of the Customer objects in the DB.
     */
    @Override
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> bankCustomers = customerRepository.findAll();
        return ResponseEntity.ok(bankCustomers);
    }

    /**
     * Endpoint returns a Customer object for a given ID.
     * If a customer does not belong to the provided ID, then a BankResourceNotFoundException
     * is thrown.
     *
     * @param customerId Customer ID (required)
     * @return ResponseEntity containing the Customer object.
     */
    @Override
    public ResponseEntity<Customer> getCustomerByID(Integer customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer == null) {
            throw new BankResourceNotFoundException(String.format("Customer not found for id: %d", customerId));
        }
        return ResponseEntity.ok(customer);
    }

    /**
     * POST endpoint for creating a new Customer.
     * Creates a new customer with the provided name and age and adds an id.
     *
     * @param requestBody - name and age
     * @return the new customer.
     */
    @Override
    public ResponseEntity<Customer> addCustomer(AddCustomerModel requestBody) {

        if(requestBody == null) {
            throw new BankBadRequestException("Request body is empty");
        } else if(requestBody.getCustomerName() == null) {
            throw new BankBadRequestException("Customer name required");
        } else if(requestBody.getCustomerAge() == null) {
            throw new BankBadRequestException("Customer age required");
        }

        int newID = customerRepository.findMaxId() + 1;

        Customer customer = new Customer();
        customer.setCustomerId(newID);
        customer.setCustomerName(requestBody.getCustomerName());
        customer.setCustomerAge(requestBody.getCustomerAge());

        customerRepository.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * GET '/bankaccounts' endpoint.
     * @return ResponseEntity containing a list of the BankAccount objects in the DB.
     */
    @Override
    public ResponseEntity<List<BankAccount>> getBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        return ResponseEntity.ok(bankAccounts);
    }

    /**
     * Endpoint returns a Bank Account object for a given Bank Account Number.
     * If a Bank Account does not belong to the provided value, then a BankResourceNotFoundException
     * is thrown.
     *
     * @param bankAccountNumber Bank Account ID (required)
     * @return Response Entity containing the Bank Account object.
     */
    @Override
    public ResponseEntity<BankAccount> getBankAccountByID(Integer bankAccountNumber) {
        BankAccount bankAccount = bankAccountRepository.findByBankAccountNumber(bankAccountNumber);
        if(bankAccount == null) {
            throw new BankResourceNotFoundException(String.format("Bank Account not found for id: %d", bankAccountNumber));
        }
        return ResponseEntity.ok(bankAccount);
    }

}
