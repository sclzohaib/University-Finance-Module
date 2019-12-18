package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.AuthorizeLvl;
import com.erp.university.Purchase.Model.User;

public class AuthorizeSignatoryDTO {
    private Long id;
    private User user;
    private AuthorizeLvl authorizeLvl;


    public AuthorizeSignatoryDTO() {
    }

    public AuthorizeSignatoryDTO(Long id) {
        this.id = id;
    }

    public AuthorizeSignatoryDTO(Long id, User user, AuthorizeLvl authorizeLvl) {
        this.id = id;
        this.user = user;
        this.authorizeLvl = authorizeLvl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AuthorizeLvl getAuthorizeLvl() {
        return authorizeLvl;
    }

    public void setAuthorizeLvl(AuthorizeLvl authorizeLvl) {
        this.authorizeLvl = authorizeLvl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuthorizeSignatoryDTO{" +
                "id=" + id +
                ", user=" + user +
                ", authorizeLvl=" + authorizeLvl +
                '}';
    }
}
