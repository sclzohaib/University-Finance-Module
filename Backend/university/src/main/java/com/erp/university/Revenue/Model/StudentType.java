package com.erp.university.Revenue.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "student_type")
public class StudentType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "st_id_sequence_g")
    @SequenceGenerator(name = "st_id_sequence_g", sequenceName = "student_type_id_seq")
    @NotNull(message = "Id cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "name can not be null")
    @NotEmpty(message = "name can not be empty")
    @NotBlank(message = "name can not be blank")
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "studentTypes")
    @JsonBackReference
    private List<FeeType> feeTypes;

    public StudentType() {
    }

    public StudentType(Long id, String name, List<FeeType> feeTypes) {
        this.id = id;
        this.name = name;
        this.feeTypes = feeTypes;
    }

    public List<FeeType> getFeeTypes() {
        return feeTypes;
    }

    public void setFeeTypes(List<FeeType> feeTypes) {
        this.feeTypes = feeTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feeTypes=" + feeTypes +
                '}';
    }
}
