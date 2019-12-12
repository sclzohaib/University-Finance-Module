package com.erp.university.Purchase.Model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "bankAccount")
public class BankAccount {


    @NotNull(message = "name can not be null")
    @NotEmpty(message= "name can not be empty")
    @Column(name = "name", unique = true, nullable = false)
    private String name;



    @NotNull(message = "Account no. can not be null")
    @NotEmpty(message= "Account no. can not be empty")
    @Column(name = "accountNumber", unique = true, nullable = false)
    private String accountNumber;

    public BankAccount() {
    }

    public BankAccount(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
