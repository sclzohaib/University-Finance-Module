package com.erp.university.Revenue.DTO;

import com.erp.university.Revenue.Model.FeeType;

import java.util.List;

public class StudentTypeDTO {
    private Long id;
    private String name;
    private List<FeeType> feeTypes;

    public StudentTypeDTO() {
    }

    public StudentTypeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentTypeDTO(Long id, String name, List<FeeType> feeTypes) {
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
        return "StudentTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feeTypes=" + feeTypes +
                '}';
    }
}
