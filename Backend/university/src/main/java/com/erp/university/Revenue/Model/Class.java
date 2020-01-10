package com.erp.university.Revenue.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_id_sequence_g")
    @SequenceGenerator(name = "class_id_sequence_g", sequenceName = "class_id_seq",allocationSize=1)
    @NotNull(message = "ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @NotEmpty(message = "Fee Types cannot be empty")
    @NotNull(message = "Fee Types cannot be null")
    @ManyToMany(mappedBy = "classes")
    @JsonBackReference
    private List<FeeType> feeTypes;

    public Class() {
    }

    public Class(String name) {
        this.name = name;
    }

    public Class(Long id, String name, List<FeeType> feeTypes) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feeTypes=" + feeTypes +
                '}';
    }
}
