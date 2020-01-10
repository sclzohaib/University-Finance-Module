package com.erp.university.Revenue.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Revenue")
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rev_id_sequence_g")
    @SequenceGenerator(name = "rev_id_sequence_g", sequenceName = "revenue_id_seq",allocationSize=1)
    @NotNull(message = "Id cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "description can not be null")
    @NotBlank(message = "description can not be blank")
    @NotEmpty(message = "description can not be empty")
    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @NotNull(message = "Revenue Head can not be null")
    @NotBlank(message = "Revenue Head can not be blank")
    @NotEmpty(message = "Revenue Head can not be empty")
    @Column(name = "revenueHead", nullable = false)
    private String revenueHead;

    @NotNull(message = " studentType can not be null")
    @NotBlank(message = "studentType can not be blank")
    @NotEmpty(message = "studentType can not be empty")
    @Column(name = "studentType")
    private String studentType;

    @NotNull(message = "Class can not be null")
    @NotBlank(message = "Class can not be blank")
    @NotEmpty(message = "Class can not be empty")
    @Column(name = "stdclass")
    private String stdClass;

    @NotNull(message = "part can not be null")
    @NotBlank(message = "part can not be blank")
    @NotEmpty(message = "part can not be empty")
    @Column(name = "part")
    private String part;

    @NotNull(message = "This field can not be null")
    @NotBlank(message = "This field can not be blank")
    @NotEmpty(message = "This field can not be empty")
    @Column(name = "withForm", nullable = false)
    private Boolean withForm;

    @NotNull(message = "This field can not be null")
    @NotBlank(message = "This field can not be blank")
    @NotEmpty(message = "This field can not be empty")
    @Column(name = "name", nullable = false)
    private Boolean isPaid;


    @NotNull(message = "Amount can not be null")
    @NotBlank(message = "Amount can not be blank")
    @NotEmpty(message = "Amount can not be empty")
    @Column(name = "amount", nullable = false)
    private Double amount;

    public Revenue() {
    }

    public Revenue(Long id, String description, String revenueHead, String studentType, String stdClass, String part, Boolean withForm, Boolean isPaid, Double amount) {
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
        return "Revenue{" +
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
