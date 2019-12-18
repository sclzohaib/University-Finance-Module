package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.University;
import com.erp.university.Purchase.Model.User;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String location;
    private Long telephone;
    private Long extensionNo;
    private University university;
    private List<User> users;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name, String location, Long telephone, Long extensionNo) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.telephone = telephone;
        this.extensionNo = extensionNo;
    }

    public DepartmentDTO(Long id, String name, String location, Long telephone, Long extensionNo, University university, List<User> users) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.telephone = telephone;
        this.extensionNo = extensionNo;
        this.university = university;
        this.users = users;
    }


    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public Long getExtensionNo() {
        return extensionNo;
    }

    public void setExtensionNo(Long extensionNo) {
        this.extensionNo = extensionNo;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", telephone=" + telephone +
                ", extensionNo=" + extensionNo +
                '}';
    }
}
