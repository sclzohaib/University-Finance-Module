package com.erp.university.Revenue.DTO;

import java.util.List;

public class FeeTypeDTO {
    private String description;
    private String revenueHead;
    private List<String> studentTypes;
    private List<String> classes;
    private List<String> parts;
    private Boolean withForm;
    private Number amount;

    public FeeTypeDTO() {
    }

    public FeeTypeDTO(String description, String revenueHead, List<String> studentTypes, List<String> classes, List<String> parts, Boolean withForm, Number amount) {
        this.description = description;
        this.revenueHead = revenueHead;
        this.studentTypes = studentTypes;
        this.classes = classes;
        this.parts = parts;
        this.withForm = withForm;
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

    public List<String> getStudentTypes() {
        return studentTypes;
    }

    public void setStudentTypes(List<String> studentTypes) {
        this.studentTypes = studentTypes;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public Boolean getWithForm() {
        return withForm;
    }

    public void setWithForm(Boolean withForm) {
        this.withForm = withForm;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }
}
