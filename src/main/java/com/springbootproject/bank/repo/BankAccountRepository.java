package com.springbootproject.bank.repo;

import com.springbootproject.bank.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repo class for the BankAccount entity.
 * Maps to the Bank_Account table.
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

    /**
     * Derived query to fetch a Bank Account by Id from the DB.
     */
    BankAccount findByBankAccountNumber(Integer bankAccountNumber);

}
