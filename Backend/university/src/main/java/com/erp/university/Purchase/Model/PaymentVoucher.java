package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "payment_voucher")
public class PaymentVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pv_id_sequence_g")
    @SequenceGenerator(name = "pv_id_sequence_g", sequenceName = "pv_seq")
    @NotNull(message = "Id cannot be null !!")
    @NotEmpty(message= "Id cannot be empty")
    @Column(name= "id",unique=true, nullable = false)
    private Long id;

    @NotNull(message = "PayeeName cannot be null !!")
    @NotBlank(message = "PayeeName cannot be blank !!")
    @NotEmpty(message= "PayeeName cannot be empty")
    @Column(name= "payee_name", nullable = false)
    @Size(min = 10, max = 50 , message = "PayeeName must be between 10 and 50 characters")
    private String payeeName;

    @NotNull(message = "Payeecode No cannot be null")
    @NotEmpty(message= "Payeecode No cannot be empty")
    @Column(name= "payee_code",unique=true, nullable = false)
    private  Long payeeCode;

    @NotNull(message = "Payment Voucher No cannot be null")
    @NotEmpty(message= "Payment Voucher No cannot be empty")
    @Column(name= "payment_voucher_no",unique= true, nullable = false)
    private Long paymentVoucherNo;

    @NotNull(message = "Date cannot be null")
    @NotEmpty(message = "date cannot be empty!!")
    @PastOrPresent(message = "Future date not allowed")
    @Column(name= "date", nullable = false)
    private Date date;

    @NotNull(message = "Account No cannot be null")
    @NotEmpty(message= "Account No cannot be empty")
    @Column(name= "account_code", unique=true, nullable = false)
    private Long accountCode;

    @NotNull(message = "Account Description cannot be null !!")
    @NotBlank(message = "Account Description cannot be blank !!")
    @NotEmpty(message= "Account Description cannot be empty")
    @Column(name= "account_description", nullable = false)
    @Size(min = 10, max = 50 , message = "Account Description must be between 10 and 50 characters")
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
