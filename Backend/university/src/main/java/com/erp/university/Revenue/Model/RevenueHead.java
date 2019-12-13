package com.erp.university.Revenue.Model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RevenueHead {

    @NotBlank(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Name cannot be null")
    @Column(name = "name",unique = true,nullable = false)
    private String name;

    @NotNull(message = "Code cannot be null")
    @NotEmpty(message = "Code cannot be empty")
    @NotBlank(message = "Code cannot be blank")
    @Column(name = "code" ,unique = true,nullable = false)
    private Number code;

    public RevenueHead() {
    }

    public RevenueHead(String name, Number code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getCode() {
        return code;
    }

    public void setCode(Number code) {
        this.code = code;
    }
}
