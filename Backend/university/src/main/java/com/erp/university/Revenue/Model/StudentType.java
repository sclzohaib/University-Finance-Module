package com.erp.university.Revenue.Model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "StudentType")
public class StudentType {


    @NotNull(message = "name can not be null")
    @NotEmpty (message = "name can not be empty")
    @NotBlank (message = "name can not be blank")
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public StudentType() {
    }

    public StudentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
