package com.erp.university.Purchase.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table (name = "Permission")
public class Permission {

    @NotNull(message = "id cannot be null !!")
    @NotEmpty(message = "id cannot be empty")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "title cannot be null !!")
    @NotEmpty(message = "title cannot be empty")
    @Size(min=1 , max = 30)
    @Column(name = "title", length = 30 , nullable = false)
    private String title;

    @NotNull(message = "name cannot be null !!")
    @NotEmpty(message = "name cannot be empty")
    @Size(min=1 , max = 30)
    @Column(name = "constName", length = 30 , nullable = false)
    private String constName;

    public Permission() {
    }

    public Permission(Long id, String title, String constName) {
        this.id = id;
        this.title = title;
        this.constName = constName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName = constName;
    }
}
