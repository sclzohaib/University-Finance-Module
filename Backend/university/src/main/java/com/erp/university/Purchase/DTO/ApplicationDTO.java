package com.erp.university.Purchase.DTO;

import java.util.Date;

public class ApplicationDTO {
    private Long id;
    private String subject;
    private Date date;
    private String status;
    private String associatePerson;

    public ApplicationDTO() {
    }

    public ApplicationDTO(Long id, String subject, Date date, String status, String associatePerson) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.status = status;
        this.associatePerson = associatePerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssociatePerson() {
        return associatePerson;
    }

    public void setAssociatePerson(String associatePerson) {
        this.associatePerson = associatePerson;
    }
}
