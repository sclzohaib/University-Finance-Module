package com.erp.university.Purchase.DTO;

public class RevenueDTO {
    private String description;
    private String revenueHead;
    private String studentType;
    private String stdClass;
    private String part;
    private Boolean withForm;
    private Boolean isPaid;
    private Number amount;

    public RevenueDTO() {
    }

    public RevenueDTO(String description, String revenueHead, String studentType, String stdClass, String part, Boolean withForm, Boolean isPaid, Number amount) {
        this.description = description;
        this.revenueHead = revenueHead;
        this.studentType = studentType;
        this.stdClass = stdClass;
        this.part = part;
        this.withForm = withForm;
        this.isPaid = isPaid;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRevenueHead() {
        return revenueHead;
    }

    public void setRevenueHead(String revenueHead) {
        this.revenueHead = revenueHead;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public String getStdClass() {
        return stdClass;
    }

    public void setStdClass(String stdClass) {
        this.stdClass = stdClass;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public Boolean getWithForm() {
        return withForm;
    }

    public void setWithForm(Boolean withForm) {
        this.withForm = withForm;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }
}
