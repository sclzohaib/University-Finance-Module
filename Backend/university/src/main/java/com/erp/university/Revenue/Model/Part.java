package com.erp.university.Revenue.Model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table (name="Part")
public class Part {

    @NotNull (message = "name can not be null")
    @NotBlank (message = "name can not be blank")
    @NotEmpty (message = "name can not be empty")
    @Column (name = "name", nullable = false , unique = true)
    private String name;

    public Part() {
    }

    public Part(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
