package com.erp.university.Revenue.DTO;

public class AdminDTO {

    private Long id;
    private String adminId;
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }

    public AdminDTO(Long id, String adminId, String password) {
        this.id = id;
        this.adminId = adminId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id=" + id +
                ", adminId='" + adminId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
