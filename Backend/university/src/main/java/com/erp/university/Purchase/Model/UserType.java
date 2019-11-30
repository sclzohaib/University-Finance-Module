package com.erp.university.Purchase.Model;

public class UserType {
    private Long id;
    private String userType;

    public UserType() {
    }

    public UserType(Long id, String userType) {
        this.id = id;
        this.userType = userType;
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
}
