package com.erp.university.Revenue.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "fee_type")
public class FeeType {
    @NotBlank(message = "Description cannot be null")
    @NotEmpty(message = "Description cannot be empty")
    @NotNull(message = "Description cannot be null")
    @Column(name = "description",unique = true,nullable = false)
    private String description;

    @NotBlank(message = "Revenue Head cannot be null")
    @NotEmpty(message = "Revenue Head cannot be empty")
    @NotNull(message = "Revenue Head cannot be null")
    @Column(name = "revenue_head",unique = false,nullable = false)
    private String revenueHead;

    @NotBlank(message = "Student Type cannot be null")
    @NotEmpty(message = "Student Type cannot be empty")
    @NotNull(message = "Student Type cannot be null")
    @Column(name = "student_type",unique = false,nullable = false)
    private List<String> studentTypes;

    @NotBlank(message = "Classes cannot be null")
    @Column(name = "classes",unique = false,nullable = true)
    private List<String> classes;

    @NotBlank(message = "Parts  cannot be null")
    @Column(name = "parts",unique = false,nullable = true)
    private List<String> parts;

    @NotBlank(message = "With_Form cannot be null")
    @NotEmpty(message = "With_Form  cannot be empty")
    @NotNull(message = "With_Form  cannot be null")
    @Column(name = "with_form",unique = false,nullable = false)
    private Boolean withForm;

    @NotBlank(message = "Amount cannot be null")
    @NotEmpty(message = "Amount  cannot be empty")
    @NotNull(message = "Amount  cannot be null")
    @Column(name = "amount",unique = false,nullable = false)
    private Number amount;

    public FeeType() {
    }

    public FeeType(String description, String revenueHead, List<String> studentTypes, List<String> classes, List<String> parts, Boolean withForm, Number amount) {
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
