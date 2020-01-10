package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.User;

import java.util.List;

public class UserTypeDTO {
    private Long id;
    private String userType;
    private List<User> users;

    public UserTypeDTO() {
    }

    public UserTypeDTO(Long id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public UserTypeDTO(Long id, String userType, List<User> users) {
        this.id = id;
        this.userType = userType;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
