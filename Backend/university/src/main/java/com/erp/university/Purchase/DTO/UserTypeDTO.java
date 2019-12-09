package com.erp.university.Purchase.DTO;

public class UserTypeDTO {
    private Long id;
    private String userType;

    public UserTypeDTO() {
    }

    public UserTypeDTO(Long id, String userType) {
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

    @Override
    public String toString() {
        return "UserTypeDTO{" +
                "id=" + id +
                ", userType='" + userType + '\'' +
                '}';
    }
}
