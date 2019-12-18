package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.Permission;
import com.erp.university.Purchase.Model.User;

import java.util.List;

public class RoleDTO {
    private Long id;
    private String title;
    private List<User> users;
    private List<Permission> permissions;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public RoleDTO(Long id, String title, List<User> users, List<Permission> permissions) {
        this.id = id;
        this.title = title;
        this.users = users;
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
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
