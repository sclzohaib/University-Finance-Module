package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.AuthorizeSignatory;
import com.erp.university.Purchase.Model.Department;
import com.erp.university.Purchase.Model.Role;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String status;
    private String address;
    private Long contactNo;
    private Department department;
    private List<Role> roles;
    private AuthorizeSignatory authorizeSignatory;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, String password, String status, String address, Long contactNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.address = address;
        this.contactNo = contactNo;
    }

    public UserDTO(Long id, String name, String email, String password, String status, String address, Long contactNo, Department department, List<Role> roles, AuthorizeSignatory authorizeSignatory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.address = address;
        this.contactNo = contactNo;
        this.department = department;
        this.roles = roles;
        this.authorizeSignatory = authorizeSignatory;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public AuthorizeSignatory getAuthorizeSignatory() {
        return authorizeSignatory;
    }

    public void setAuthorizeSignatory(AuthorizeSignatory authorizeSignatory) {
        this.authorizeSignatory = authorizeSignatory;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }
}

