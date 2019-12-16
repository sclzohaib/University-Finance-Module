package com.erp.university.Purchase.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "Role")
public class Role {

    @NotNull(message = "id cannot be null !!")
    @NotEmpty(message = "id cannot be empty")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "title cannot be null !!")
    @NotBlank(message = "title cannot be blank !!")
    @NotEmpty(message = "title cannot be empty")
    @Column(name = "title", length = 30 , nullable = false, unique = true)
    @Size(min=1, max=30)
    private String title;

    public Role() {
    }

    public Role(Long id, String title) {
        this.id = id;
        this.title = title;
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
}
