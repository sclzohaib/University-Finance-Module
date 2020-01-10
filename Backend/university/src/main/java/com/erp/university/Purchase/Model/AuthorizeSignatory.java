package com.erp.university.Purchase.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "auth_signatory")
public class AuthorizeSignatory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "as_id_sequence_g")
    @SequenceGenerator(name = "as_id_sequence_g", sequenceName = "auth_sign_seq",allocationSize=1)
    @NotNull(message = "Authorize signatory Id can not be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Name cannot be null !!")
    @NotBlank(message = "Name cannot be blank !!")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Authorize Level cannot be null")
    @ManyToOne
    @JoinColumn(name = "auth_lvl_id", referencedColumnName = "id", nullable = false)
    private AuthorizeLvl authorizeLvl;

    @OneToOne(mappedBy = "authorizeSignatory")
    @JsonBackReference
    private User user;

    public AuthorizeSignatory() {
    }

    public AuthorizeSignatory(Long id, AuthorizeLvl authorizeLvl, User user,String name) {
        this.id = id;
        this.authorizeLvl = authorizeLvl;
        this.user = user;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorizeLvl getAuthorizeLvl() {
        return authorizeLvl;
    }

    public void setAuthorizeLvl(AuthorizeLvl authorizeLvl) {
        this.authorizeLvl = authorizeLvl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
