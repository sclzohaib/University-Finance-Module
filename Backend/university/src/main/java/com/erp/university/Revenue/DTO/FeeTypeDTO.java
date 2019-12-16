package com.erp.university.Revenue.DTO;

import com.erp.university.Revenue.Model.Class;
import com.erp.university.Revenue.Model.Part;
import com.erp.university.Revenue.Model.StudentType;

import java.util.List;

public class FeeTypeDTO {
    private Long id;
    private String description;
    private String revenueHead;
    private List<StudentType> studentTypes;
    private List<Class> classes;
    private List<Part> parts;
    private Boolean withForm;
    private Double amount;

    public FeeTypeDTO() {
    }

    public FeeTypeDTO(Long id, String description, String revenueHead, List<StudentType> studentTypes, List<Class> classes, List<Part> parts, Boolean withForm, Double amount) {
        this.id = id;
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

    public List<StudentType> getStudentTypes() {
        return studentTypes;
    }

    public void setStudentTypes(List<StudentType> studentTypes) {
        this.studentTypes = studentTypes;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Boolean getWithForm() {
        return withForm;
    }

    public void setWithForm(Boolean withForm) {
        this.withForm = withForm;
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
        return "FeeTypeDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", revenueHead='" + revenueHead + '\'' +
                ", studentTypes=" + studentTypes +
                ", classes=" + classes +
                ", parts=" + parts +
                ", withForm=" + withForm +
                ", amount=" + amount +
                '}';
    }
}
