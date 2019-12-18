package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.Department;

import java.util.List;

public class UniversityDTO {
    private Long id;
    private String name;
    private String location;
    private List<Department> departments;

    public UniversityDTO() {
    }

    public UniversityDTO(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public UniversityDTO(Long id, String name, String location, List<Department> departments) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
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

    @Override
    public String toString() {
        return "UniversityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
