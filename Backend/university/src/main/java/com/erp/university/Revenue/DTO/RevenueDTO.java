package com.erp.university.Revenue.DTO;

public class RevenueDTO {
    private Long id;
    private String description;
    private String revenueHead;
    private String studentType;
    private String stdClass;
    private String part;
    private Boolean withForm;
    private Boolean isPaid;
    private Double amount;

    public RevenueDTO() {
    }

    public RevenueDTO(Long id, String description, String revenueHead, String studentType, String stdClass, String part, Boolean withForm, Boolean isPaid, Double amount) {
        this.id = id;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RevenueDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", revenueHead='" + revenueHead + '\'' +
                ", studentType='" + studentType + '\'' +
                ", stdClass='" + stdClass + '\'' +
                ", part='" + part + '\'' +
                ", withForm=" + withForm +
                ", isPaid=" + isPaid +
                ", amount=" + amount +
                '}';
    }
}
