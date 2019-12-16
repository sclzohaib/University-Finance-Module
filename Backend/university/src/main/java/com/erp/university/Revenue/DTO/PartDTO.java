package com.erp.university.Revenue.DTO;

import com.erp.university.Revenue.Model.FeeType;

import java.util.List;

public class PartDTO {
    private Long id;
    private String name;
    private List<FeeType> feeTypes;

    public PartDTO() {
    }

    public PartDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PartDTO(Long id, String name, List<FeeType> feeTypes) {
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
        return "PartDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feeTypes=" + feeTypes +
                '}';
    }
}
