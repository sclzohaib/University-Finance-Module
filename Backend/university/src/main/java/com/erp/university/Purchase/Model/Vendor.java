package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table (name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "vendor_seq")

    @NotNull(message = "Vendor ID cannot be null")
    @NotEmpty(message = "Vendor ID cannot be empty")
    @Column(name = "vendor_id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Vendor Name cannot be null")
    @NotEmpty(message = "Vendor Name cannot be empty")
    @NotBlank(message = "Vendor Name cannot be blank")
    @Size(min = 5, max = 30, message = "Name must be between 5 to 30 characters")
    @Column(name = "vendor_name", nullable = false)
    private String vName;

    @NotNull(message = "Phone no cannot be null")
    @NotEmpty(message = "Phone no cannot be empty")
    @Column(name = "telephone_no", unique = true, nullable = false)
    private Long tel;

    @NotNull(message = "Tender Date cannot be null")
    @NotEmpty(message = "Tender Date cannot be empty")
    @NotBlank(message = "Tender Date cannot be blank")
    @Column(name = "t_date", nullable = false)
    private Date tDate;

    @NotNull(message = "Tender Last date cannot be null")
    @NotEmpty(message = "Tender Last Date cannot be empty")
    @NotBlank(message = "Tender Last Date cannot be blank")
    @Column(name = "t_last_date", nullable = false)
    private Date tLastDate;

    @NotNull(message = "Tender Quotation Amount cannot be null")
    @NotEmpty(message = "Tender Quotation Amount cannot be empty")
    @Column(name = "t_quotation_amount", nullable = false)
    private Double tQuotationAmount;

    public Vendor() {
    }

    public Vendor(Long id, String vName, Long tel, Date tDate, Date tLastDate, Double tQuotationAmount) {
        this.id = id;
        this.vName = vName;
        this.tel = tel;
        this.tDate = tDate;
        this.tLastDate = tLastDate;
        this.tQuotationAmount = tQuotationAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public Date gettLastDate() {
        return tLastDate;
    }

    public void settLastDate(Date tLastDate) {
        this.tLastDate = tLastDate;
    }

    public Double gettQuotationAmount() {
        return tQuotationAmount;
    }

    public void settQuotationAmount(Double tQuotationAmount) {
        this.tQuotationAmount = tQuotationAmount;
    }
}
