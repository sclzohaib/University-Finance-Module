package com.erp.university.Purchase.DTO;

public class MajorHeadDTO {
    private Long id;
    private String name;

    public MajorHeadDTO() {
    }

    public MajorHeadDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
