package com.erp.university.Purchase.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_id_sequence_g")
    @SequenceGenerator(name = "permission_id_sequence_g", sequenceName = "permission_seq",allocationSize=1)
    @NotNull(message = "id cannot be null !!")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "title cannot be null !!")
    @NotEmpty(message = "title cannot be empty")
    @NotBlank(message = "title cannot be blank !!")
    @Size(min = 1, max = 30)
    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @NotNull(message = "constName cannot be null !!")
    @NotEmpty(message = "constName cannot be empty")
    @NotBlank(message = "constName cannot be blank !!")
    @Size(min = 1, max = 30)
    @Column(name = "constName", length = 30, nullable = false)
    private String constName;

    @ManyToMany(mappedBy = "permissions")
    @JsonBackReference
    private List<Role> roles;

    public Permission() {
    }

    public Permission(Long id, String title, String constName, List<Role> roles) {
        this.id = id;
        this.title = title;
        this.constName = constName;
        this.roles = roles;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
