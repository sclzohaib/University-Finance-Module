package com.erp.university.Purchase.DTO;

import com.erp.university.Purchase.Model.AuthorizeSignatory;

import java.util.List;

public class AuthorizeLvlDTO {
    private Long id;
    private Long lvlNo;
    private List<AuthorizeSignatory> authorizeSignatories;

    public AuthorizeLvlDTO() {
    }

    public AuthorizeLvlDTO(Long id, Long lvlNo) {
        this.id = id;
        this.lvlNo = lvlNo;
    }

    public AuthorizeLvlDTO(Long id, Long lvlNo, List<AuthorizeSignatory> authorizeSignatories) {
        this.id = id;
        this.lvlNo = lvlNo;
        this.authorizeSignatories = authorizeSignatories;
    }

    public AuthorizeLvlDTO(Long lvlNo) {
        this.lvlNo = lvlNo;
    }

    public List<AuthorizeSignatory> getAuthorizeSignatories() {
        return authorizeSignatories;
    }

    public void setAuthorizeSignatories(List<AuthorizeSignatory> authorizeSignatories) {
        this.authorizeSignatories = authorizeSignatories;
    }

    public Long getLvlNo() {
        return lvlNo;
    }

    public void setLvlNo(Long lvlNo) {
        this.lvlNo = lvlNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuthorizeLvlDTO{" +
                "id=" + id +
                ", lvlNo=" + lvlNo +
                '}';
    }
}
