package com.erp.university.Purchase.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_sequence_g")
    @SequenceGenerator(name = "role_id_sequence_g", sequenceName = "role_seq")
    @NotNull(message = "id cannot be null !!")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "title cannot be null !!")
    @NotBlank(message = "title cannot be blank !!")
    @NotEmpty(message = "title cannot be empty")
    @Column(name = "title", length = 30, nullable = false, unique = true)
    @Size(min = 1, max = 30)
    private String title;

    @NotEmpty(message = "permissions cannot be empty")
    @NotNull(message = "permissions cannot be null")
    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)
    )
    private List<Permission> permissions;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private List<User> users;

    public Role() {
    }

    public Role(Long id, String title, List<Permission> permissions, List<User> users) {
        this.id = id;
        this.title = title;
        this.permissions = permissions;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }
}
