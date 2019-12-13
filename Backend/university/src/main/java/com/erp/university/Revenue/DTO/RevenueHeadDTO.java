package com.erp.university.Revenue.DTO;

public class RevenueHeadDTO {
    private String name;
    private Number code;

    public RevenueHeadDTO() {
    }

    public RevenueHeadDTO(String name, Number code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getCode() {
        return code;
    }

    public void setCode(Number code) {
        this.code = code;
    }
}
