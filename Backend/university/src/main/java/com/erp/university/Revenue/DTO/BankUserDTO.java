package com.erp.university.Revenue.DTO;

public class BankUserDTO {
    private Long id;
    private String bankId;
    private String password;

    public BankUserDTO() {
    }

    public BankUserDTO(String bankId, String password) {
        this.bankId = bankId;
        this.password = password;
    }

    public BankUserDTO(Long id, String bankId, String password) {
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
        return "BankUserDTO{" +
                "id=" + id +
                ", bankId='" + bankId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
