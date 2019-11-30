package com.erp.university.Purchase.Model;

import java.util.Date;

public class PaymentVoucher {
    private Long id;
    private String payeeName;
    private  Long payeeCode;
    private Long paymentVoucherNo;
    private Date date;
    private Long accountCode;
    private String accountDescription;

    public PaymentVoucher() {
    }

    public PaymentVoucher(Long id, String payeeName, Long payeeCode, Long paymentVoucherNo, Date date, Long accountCode, String accountDescription) {
        this.id = id;
        this.payeeName = payeeName;
        this.payeeCode = payeeCode;
        this.paymentVoucherNo = paymentVoucherNo;
        this.date = date;
        this.accountCode = accountCode;
        this.accountDescription = accountDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public Long getPayeeCode() {
        return payeeCode;
    }

    public void setPayeeCode(Long payeeCode) {
        this.payeeCode = payeeCode;
    }

    public Long getPaymentVoucherNo() {
        return paymentVoucherNo;
    }

    public void setPaymentVoucherNo(Long paymentVoucherNo) {
        this.paymentVoucherNo = paymentVoucherNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(Long accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }
}
