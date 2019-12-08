package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ledger_of_expenditure")
public class LedgerOfExpenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loe_id_sequence_g")
    @SequenceGenerator(name = "loe_id_sequence_g", sequenceName = "loe_seq")
    @NotNull(message = "Ledger of expendidure ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Particulars cannot be null")
    @NotEmpty(message = "Particulars cannot be empty")
    @NotBlank(message = "Particulars cannot be blank")
    @Column(name = "particulars", nullable = false)
    private String particulars;

    @NotNull(message = "Debit amount cannot be null")
    @Column(name = "debit_amount", nullable = false)
    private Double debitAmount;

    @NotNull(message = "Balance cannot be null")
    @Column(name = "balance", nullable = false)
    private Double balance;

    @NotNull(message = "Date cannot be null")
    @Column(name = "loe_date", nullable = false)
    private Date date;

    public LedgerOfExpenditure() {
    }

    public LedgerOfExpenditure(Long id, String particulars, Double debitAmount, Double balance, Date date) {
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
