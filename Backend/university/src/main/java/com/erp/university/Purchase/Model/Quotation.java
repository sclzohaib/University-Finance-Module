package com.erp.university.Purchase.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import java.util.Date;


public class Quotation {


    private Long id;
    private Long refNo;
    private Date date;
    private String termsCondition;
    private Long total;

    public Quotation() {
    }


    public Quotation(Long id, Long refNo, Date date, String termsCondition, Long total) {
        this.id = id;
        this.refNo = refNo;
        this.date = date;
        this.termsCondition = termsCondition;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRefNo() {
        return refNo;
    }

    public void setRefNo(Long refNo) {
        this.refNo = refNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(String termsCondition) {
        this.termsCondition = termsCondition;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
