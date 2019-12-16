package com.erp.university.Purchase.DTO;

public class RoleDTO {
    private Long id;
    private String title;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String title) {
        this.id = id;
        this.title = title;
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
}
