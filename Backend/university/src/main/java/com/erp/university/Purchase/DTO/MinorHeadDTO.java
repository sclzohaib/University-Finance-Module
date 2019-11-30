package com.erp.university.Purchase.DTO;

public class MinorHeadDTO {
    private Long id;
    private String name;
    private Long codeNo;

    public MinorHeadDTO() {
    }

    public MinorHeadDTO(Long id, String name, Long codeNo) {
        this.id = id;
        this.name = name;
        this.codeNo = codeNo;
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

    public Long getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(Long codeNo) {
        this.codeNo = codeNo;
    }
}
