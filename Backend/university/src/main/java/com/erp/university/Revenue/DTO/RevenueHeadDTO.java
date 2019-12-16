package com.erp.university.Revenue.DTO;

public class RevenueHeadDTO {
    private Long id;
    private String name;
    private Long code;

    public RevenueHeadDTO() {
    }

    public RevenueHeadDTO(Long id, String name, Long code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RevenueHeadDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
