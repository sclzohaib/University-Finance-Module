package com.erp.university.Revenue.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bank_user")
public class BankUser {

    @NotNull(message = "ID cannot be null")
    @Column(name = "bank_id",unique = true,nullable = false)
    private String bankId;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be empty")
    @NotEmpty(message = "Password cannot be empty")
    @Column(name = "password",unique = false,nullable = false)
    private String password;

    public BankUser() {
    }

    public BankUser(String bankId, String password) {
        this.bankId = bankId;
        this.password = password;
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
}
