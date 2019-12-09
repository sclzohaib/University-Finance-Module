package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
@Table(name = "budget_sheet")
public class BudgetSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bs_id_sequence_g")
    @SequenceGenerator(name = "bs_id_sequence_g", sequenceName = "bs_seq")
    @NotNull(message = "ID can not be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "date can not be null")
    @PastOrPresent(message = "date can not be of future")
    @Column(name = "bs_date", nullable = false)
    private Date date;

    @NotNull(message = "budget allocation  can not be null")
    @Positive(message = "budget allocated can neither be zero nor negative")
    @Column(name = "budget_allocation", nullable = false)
    private Double budgetAllocation;


    @NotNull(message = "upto date expenditure  can not be null")
    @PositiveOrZero(message = "upto date expenditure can not be negative")
    @Column(name = "upto_date_exp", nullable = false)
    private Double uptoDateExp;


    @NotNull(message = "bill amount  can not be null")
    @Positive(message = "bill amount can neither be zero nor negative")
    @Column(name = "bill_amount", nullable = false)
    private Double billAmount;

    @NotNull(message = "total expense  can not be null")
    @PositiveOrZero(message = "total expense can not be negative")
    @Column(name = "total_exp", nullable = false)
    private Double totalExpense;

    @NotNull(message = "balance available  can not be null")
    @PositiveOrZero(message = "balance available can not be negative")
    @Column(name = "balance_available")
    private Double balanceAvailable;

    @NotNull(message = "over expenditure  can not be null")
    @PositiveOrZero(message = "over expenditure can not be negative")
    @Column(name = "over_exp")
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

    @Override
    public String toString() {
        return "BudgetSheet{" +
                "id=" + id +
                ", date=" + date +
                ", budgetAllocation=" + budgetAllocation +
                ", uptoDateExp=" + uptoDateExp +
                ", billAmount=" + billAmount +
                ", totalExpense=" + totalExpense +
                ", balanceAvailable=" + balanceAvailable +
                ", overExp=" + overExp +
                '}';
    }
}
