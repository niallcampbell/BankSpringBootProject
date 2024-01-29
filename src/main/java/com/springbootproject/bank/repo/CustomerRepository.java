package com.springbootproject.bank.repo;

import com.springbootproject.bank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repo class for the Customer entity.
 * Maps to the Customer table.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
