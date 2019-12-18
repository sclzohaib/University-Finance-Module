package com.erp.university.Purchase.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "auth_signatory")
public class AuthorizeSignatory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "as_id_sequence_g")
    @SequenceGenerator(name = "as_id_sequence_g", sequenceName = "auth_sign_seq")
    @NotNull(message = "Authorize signatory Id can not be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    @NotNull(message = "Authorize Level cannot be null")
    @ManyToOne
    @JoinColumn(name = "auth_lvl_id", referencedColumnName = "id", nullable = false)
    private AuthorizeLvl authorizeLvl;

    @OneToOne(mappedBy = "authorizeSignatory")
    @JsonBackReference
    private User user;

    public AuthorizeSignatory() {
    }

    public AuthorizeSignatory(Long id, AuthorizeLvl authorizeLvl, User user) {
        this.id = id;
        this.authorizeLvl = authorizeLvl;
        this.user = user;
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

    @Override
    public String toString() {
        return "AuthorizeSignatory{" +
                "id=" + id +
                ", authorizeLvl=" + authorizeLvl +
                ", user=" + user +
                '}';
    }
}
