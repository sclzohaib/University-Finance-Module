package com.erp.university.Revenue.DTO;

public class BankUserDTO {
    private String bankId;
    private String password;

    public BankUserDTO() {
    }

    public BankUserDTO(String bankId, String password) {
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
