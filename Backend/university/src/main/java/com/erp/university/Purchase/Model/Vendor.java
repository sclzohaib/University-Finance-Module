package com.erp.university.Purchase.Model;

import java.util.Date;

public class Vendor {
    private Long id;
    private String vName;
    private Long tel;
    private Date tDate;
    private Date tLastDate;
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
