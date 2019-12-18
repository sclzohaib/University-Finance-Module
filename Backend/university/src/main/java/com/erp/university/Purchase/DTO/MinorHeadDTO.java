package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.MajorHead;

public class MinorHeadDTO {
    private Long id;
    private String name;
    private Long codeNo;
    private MajorHead majorHead;

    public MinorHeadDTO() {
    }

    public MinorHeadDTO(Long id, String name, Long codeNo) {
        this.id = id;
        this.name = name;
        this.codeNo = codeNo;
    }

    public MinorHeadDTO(Long id, String name, Long codeNo, MajorHead majorHead) {
        this.id = id;
        this.name = name;
        this.codeNo = codeNo;
        this.majorHead = majorHead;
    }

    public MajorHead getMajorHead() {
        return majorHead;
    }

    public void setMajorHead(MajorHead majorHead) {
        this.majorHead = majorHead;
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

    @Override
    public String toString() {
        return "MinorHeadDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codeNo=" + codeNo +
                '}';
    }
}
