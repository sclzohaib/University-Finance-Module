package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.MinorHead;

import java.util.List;

public class MajorHeadDTO {
    private Long id;
    private String name;
    private List<MinorHead> minorHeads;

    public MajorHeadDTO() {
    }

    public MajorHeadDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MajorHeadDTO(Long id, String name, List<MinorHead> minorHeads) {
        this.id = id;
        this.name = name;
        this.minorHeads = minorHeads;
    }

    public List<MinorHead> getMinorHeads() {
        return minorHeads;
    }

    public void setMinorHeads(List<MinorHead> minorHeads) {
        this.minorHeads = minorHeads;
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
        return "MajorHeadDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
