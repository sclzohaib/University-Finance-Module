package com.erp.university.Revenue.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "fee_type")
public class FeeType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ft_id_sequence_g")
    @SequenceGenerator(name = "ft_id_sequence_g", sequenceName = "fee_type_id_seq")
    @NotNull(message = "Id cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotBlank(message = "Description cannot be null")
    @NotEmpty(message = "Description cannot be empty")
    @NotNull(message = "Description cannot be null")
    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @NotBlank(message = "Revenue Head cannot be null")
    @NotEmpty(message = "Revenue Head cannot be empty")
    @NotNull(message = "Revenue Head cannot be null")
    @Column(name = "revenue_head", nullable = false)
    private String revenueHead;


    @NotEmpty(message = "Student Type cannot be empty")
    @NotNull(message = "Student Type cannot be null")
    @ManyToMany
    @JoinTable(name = "feetype_studenttype", joinColumns = @JoinColumn(name = "fee_type_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "student_type_id", referencedColumnName = "id", nullable = false))
    private List<StudentType> studentTypes;

    @NotEmpty(message = "classes cannot be empty")
    @NotNull(message = "classes cannot be null")
    @ManyToMany
    @JoinTable(name = "feetype_class", joinColumns = @JoinColumn(name = "fee_type_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"))
    private List<Class> classes;

    @NotEmpty(message = "parts cannot be empty")
    @NotNull(message = "parts cannot be null")
    @ManyToMany
    @JoinTable(name = "feetype_part", joinColumns = @JoinColumn(name = "fee_type_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    private List<Part> parts;

    @NotBlank(message = "With_Form cannot be null")
    @NotEmpty(message = "With_Form  cannot be empty")
    @NotNull(message = "With_Form  cannot be null")
    @Column(name = "with_form", nullable = false)
    private Boolean withForm;

    @NotBlank(message = "Amount cannot be null")
    @NotEmpty(message = "Amount  cannot be empty")
    @NotNull(message = "Amount  cannot be null")
    @Column(name = "amount", nullable = false)
    private Double amount;

    public FeeType() {
    }

    public FeeType(Long id, String description, String revenueHead, List<StudentType> studentTypes, List<Class> classes, List<Part> parts, Boolean withForm, Double amount) {
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
        return "FeeType{" +
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
