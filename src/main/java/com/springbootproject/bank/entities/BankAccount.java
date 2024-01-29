package com.springbootproject.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity class for BankAccount.
 * Maps to the Bank_Account table in the DB.
 */
@Entity
@Table(name="Bank_Account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankAccount {

    @Id
    @Column(name = "ACCOUNT_ID", nullable = false)
    private Integer bankAccountNumber;

    @Column(name = "ACCOUNT_TYPE")
    private String bankAccountType;

    /**
     * BankAccount has a CUSTOMER_ID column.
     * The @JoinColumn annotation adds a foreign key constraint pointing
     * to the customer ID column in the Customer table.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;

}
