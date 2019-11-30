package com.erp.university.Purchase.DTO;

import java.util.Date;

public class BudgetSheetDTO {
    private Long id;
    private Date date;
    private Double budgetAllocation;
    private Double upToDateExp;
    private Double billAmount;
    private Double totalExpense;
    private Double blnceAvail;
    private Double overExp;

    public BudgetSheetDTO() {
    }

    public BudgetSheetDTO(Long id, Date date, Double budgetAllocation, Double upToDateExp, Double billAmount, Double totalExpense, Double blnceAvail, Double overExp) {
        this.id = id;
        this.date = date;
        this.budgetAllocation = budgetAllocation;
        this.upToDateExp = upToDateExp;
        this.billAmount = billAmount;
        this.totalExpense = totalExpense;
        this.blnceAvail = blnceAvail;
        this.overExp = overExp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getBudgetAllocation() {
        return budgetAllocation;
    }

    public void setBudgetAllocation(Double budgetAllocation) {
        this.budgetAllocation = budgetAllocation;
    }

    public Double getUpToDateExp() {
        return upToDateExp;
    }

    public void setUpToDateExp(Double upToDateExp) {
        this.upToDateExp = upToDateExp;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Double getBlnceAvail() {
        return blnceAvail;
    }

    public void setBlnceAvail(Double blnceAvail) {
        this.blnceAvail = blnceAvail;
    }

    public Double getOverExp() {
        return overExp;
    }

    public void setOverExp(Double overExp) {
        this.overExp = overExp;
    }
}
