package com.erp.university.Revenue.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_id_sequence_g")
    @SequenceGenerator(name = "admin_id_sequence_g", sequenceName = "admin_id_seq")
    @NotNull(message = "Admin ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Admin ID cannot be null")
    @NotEmpty(message = "Admin ID cannot be empty")
    @NotBlank(message = "Admin ID cannot be blank")
    @Column(name = "admin_id",unique = true ,nullable = false)
    private String adminId;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password cannot be blank")
    @Column(name = "password",nullable = false)
    private String password;

    public Admin() {
    }

    public Admin(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }

    public Admin(Long id, String adminId, String password) {
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
}
