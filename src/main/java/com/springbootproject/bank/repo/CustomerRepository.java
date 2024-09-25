package com.springbootproject.bank.repo;

import com.springbootproject.bank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repo class for the Customer entity.
 * Maps to the Customer table.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerId(Integer customerId);

    @Query(value = "SELECT MAX(CUSTOMER_ID) FROM Customer", nativeQuery = true)
    Integer findMaxId();

}
