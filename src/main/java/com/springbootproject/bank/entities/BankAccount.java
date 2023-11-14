package com.springbootproject.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
     * Foreign key pointing to the customer ID column in the Customer table.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;

}
