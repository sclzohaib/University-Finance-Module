package com.erp.university.Revenue.DTO;

public class BankAccountDTO {
    private Long id;
    private String name;
    private String accountNumber;

    public BankAccountDTO() {
    }

    public BankAccountDTO(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public BankAccountDTO(Long id, String name, String accountNumber) {
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
        return "BankAccountDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
