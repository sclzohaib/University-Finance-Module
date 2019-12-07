package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
@Entity
@Table (name = "BudgetSheet")
public class BudgetSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "bs_seq")
    @NotNull (message = "ID can not be null")
    @NotEmpty (message = "ID can not be empty")
    @Column (name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull (message = "date can not be null")
    @NotEmpty (message = "date can not be empty")
    @PastOrPresent (message = "date can not be of future")
    @Column (name = "date", nullable = false)
    private Date date;

    @NotNull (message = "budget allocation  can not be null")
    @NotEmpty (message = "budget allocation can not be empty")
    @Positive (message= "budget allocated can neither be zero nor negative")
    @Column (name = "budget_allocation", nullable = false)
    private Double budgetAllocation;


    @NotNull (message = "upto date expenditure  can not be null")
    @NotEmpty (message = " upto date expenditure can not be empty")
    @PositiveOrZero (message= "upto date expenditure can not be negative")
    @Column (name = "upto_date_exp", nullable = false)
    private Double uptoDateExp;



    @NotNull (message = "bill amount  can not be null")
    @NotEmpty (message = " bill amount can not be empty")
    @Positive (message= "bill amount can neither be zero nor negative")
    @Column (name = "bill_amount", nullable = false)
    private Double billAmount;

    @NotNull (message = "total expense  can not be null")
    @NotEmpty (message = " total expense can not be empty")
    @PositiveOrZero (message= "total expense can not be negative")
    @Column (name = "total_exp", nullable = false)
    private Double totalExpense;


    @PositiveOrZero (message= "balance available can not be negative")
    @Column (name = "balance_available", nullable = true)
    private Double balanceAvailable;

    @PositiveOrZero (message= "over expenditure can not be negative")
    @Column (name = "over_exp", nullable = true)
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
