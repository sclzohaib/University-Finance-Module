package com.erp.university.Purchase.Model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name="Revenue")
public class Revenue {

    @NotNull(message = "description can not be null")
    @NotBlank(message = "description can not be blank")
    @NotEmpty(message = "description can not be empty")
    @Column(name = "description", nullable = false , unique = true)
    private String description;

    @NotNull (message = "Revenue Head can not be null")
    @NotBlank (message = "Revenue Head can not be blank")
    @NotEmpty (message = "Revenue Head can not be empty")
    @Column (name = "revenueHead", nullable = false)
    private String revenueHead;

    @NotNull (message = " studentType can not be null")
    @NotBlank (message = "studentType can not be blank")
    @NotEmpty (message = "studentType can not be empty")
    @Column (name = "studentType", nullable = false)
    private String studentType;

    @NotNull (message = "Class can not be null")
    @NotBlank (message = "Class can not be blank")
    @NotEmpty (message = "Class can not be empty")
    @Column (name = "stdclass", nullable = true)
    private String stdClass;

    @NotNull (message = "part can not be null")
    @NotBlank (message = "part can not be blank")
    @NotEmpty (message = "part can not be empty")
    @Column (name = "part", nullable = true)
    private String part;

    @NotNull (message = "This field can not be null")
    @NotBlank (message = "This field can not be blank")
    @NotEmpty (message = "This field can not be empty")
    @Column (name = "withForm", nullable = false)
    private Boolean withForm;

    @NotNull (message = "This field can not be null")
    @NotBlank (message = "This field can not be blank")
    @NotEmpty (message = "This field can not be empty")
    @Column (name = "name", nullable = false)
    private Boolean isPaid;


    @NotNull (message = "Amount can not be null")
    @NotBlank (message = "Amount can not be blank")
    @NotEmpty (message = "Amount can not be empty")
    @Column (name = "amount", nullable = false)
    private Number amount;

    public Revenue() {
    }

    public Revenue(String description, String revenueHead, String studentType, String stdClass, String part, Boolean withForm, Boolean isPaid, Number amount) {
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
