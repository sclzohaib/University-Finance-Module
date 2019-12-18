package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.Role;

import java.util.List;

public class PermissionDTO {
    private Long id;
    private String title;
    private String constName;
    private List<Role> roles;

    public PermissionDTO() {
    }

    public PermissionDTO(Long id, String title, String constName) {
        this.id = id;
        this.title = title;
        this.constName = constName;
    }

    public PermissionDTO(Long id, String title, String constName, List<Role> roles) {
        this.id = id;
        this.title = title;
        this.constName = constName;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
