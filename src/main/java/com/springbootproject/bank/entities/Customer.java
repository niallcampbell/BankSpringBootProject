package com.springbootproject.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for Customer.
 * Maps to the Customer table in the DB.
 */
@Entity
@Table(name="Customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer customerId;

    @Column(name = "CUSTOMER_NAME", nullable = true)
    private String customerName;

    @Column(name = "CUSTOMER_AGE")
    private Integer customerAge;
}
