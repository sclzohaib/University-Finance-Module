package com.erp.university.Purchase.Model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class BudgetSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "bs_seq")
    private Long id;
    private Date date;
    private Double budgetAllocation;
    private Double uptoDateExp;
    private Double billAmount;
    private Double totalExpense;
    private Double balanceAvailable;
    private Double overExp;

    public BudgetSheet() {
    }

    public BudgetSheet(Date date, Double budgetAllocation, Double uptoDateExp, Double billAmount, Double totalExpense, Double balanceAvailable, Double overExp) {
        this.date = date;
        this.budgetAllocation = budgetAllocation;
        this.uptoDateExp = uptoDateExp;
        this.billAmount = billAmount;
        this.totalExpense = totalExpense;
        this.balanceAvailable = balanceAvailable;
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

    public Double getUptoDateExp() {
        return uptoDateExp;
    }

    public void setUptoDateExp(Double uptoDateExp) {
        this.uptoDateExp = uptoDateExp;
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

    public Double getBalanceAvailable() {
        return balanceAvailable;
    }

    public void setBalanceAvailable(Double balanceAvailable) {
        this.balanceAvailable = balanceAvailable;
    }

    public Double getOverExp() {
        return overExp;
    }

    public void setOverExp(Double overExp) {
        this.overExp = overExp;
    }
}
