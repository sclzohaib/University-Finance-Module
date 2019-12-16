package com.erp.university.Purchase.DTO;

public class PermissionDTO {
    private Long id;
    private String title;
    private String constName;

    public PermissionDTO() {
    }

    public PermissionDTO(Long id, String title, String constName) {
        this.id = id;
        this.title = title;
        this.constName = constName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName = constName;
    }
}
