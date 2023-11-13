package com.springbootproject.bank.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BankAccount")
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

    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

}
