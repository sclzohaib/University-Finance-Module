package com.erp.university.Revenue.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bankAccount")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ba_id_sequence_g")
    @SequenceGenerator(name = "ba_id_sequence_g", sequenceName = "ba_id_seq")
    @NotNull(message = "Bank Account ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be blank")
    @NotEmpty(message = "name can not be empty")
    @Column(name = "name", unique = true, nullable = false)
    private String name;


    @NotNull(message = "Account no. can not be null")
    @NotEmpty(message = "Account no. can not be empty")
    @NotBlank(message = "Account no. can not be blank")
    @Column(name = "accountNumber", unique = true, nullable = false)
    private String accountNumber;

    public BankAccount() {
    }

    public BankAccount(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public BankAccount(Long id, String name, String accountNumber) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
