package com.erp.university.Revenue.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bank_user")
public class BankUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bu_id_sequence_g")
    @SequenceGenerator(name = "bu_id_sequence_g", sequenceName = "bu_id_seq")
    @NotNull(message = "ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @NotNull(message = "Bank ID cannot be null")
    @NotBlank(message = "Bank ID cannot be empty")
    @NotEmpty(message = "Bank ID cannot be empty")
    @Column(name = "bank_id", unique = true, nullable = false)
    private String bankId;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be empty")
    @NotEmpty(message = "Password cannot be empty")
    @Column(name = "password", nullable = false)
    private String password;

    public BankUser() {
    }

    public BankUser(String bankId, String password) {
        this.bankId = bankId;
        this.password = password;
    }

    public BankUser(Long id, String bankId, String password) {
        this.id = id;
        this.bankId = bankId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BankUser{" +
                "id=" + id +
                ", bankId='" + bankId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
