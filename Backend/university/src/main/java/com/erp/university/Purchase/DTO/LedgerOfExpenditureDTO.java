package com.erp.university.Purchase.DTO;

import java.util.Date;

public class LedgerOfExpenditureDTO {
    private Long id;
    private  String particulars;
    private Double debitAmount;
    private Double balance;
    private Date date;

    public LedgerOfExpenditureDTO() {
    }

    public LedgerOfExpenditureDTO(Long id, String particulars, Double debitAmount, Double balance, Date date) {
        this.id = id;
        this.particulars = particulars;
        this.debitAmount = debitAmount;
        this.balance = balance;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public Double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
