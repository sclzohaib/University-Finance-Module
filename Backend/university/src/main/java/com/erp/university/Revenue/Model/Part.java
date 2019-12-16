package com.erp.university.Revenue.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Part")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "part_id_sequence_g")
    @SequenceGenerator(name = "part_id_sequence_g", sequenceName = "part_id_seq")
    @NotNull(message = "Id cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be blank")
    @NotEmpty(message = "name can not be empty")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "parts")
    @JsonBackReference
    private List<FeeType> feeTypes;

    public Part() {
    }

    public Part(Long id, String name, List<FeeType> feeTypes) {
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
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feeTypes=" + feeTypes +
                '}';
    }
}
