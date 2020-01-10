package com.erp.university.Purchase.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "auth_lvl")
public class AuthorizeLvl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "al_id_sequence_g")
    @SequenceGenerator(name = "al_id_sequence_g", sequenceName = "auth_lvl_seq", allocationSize=1)
    @NotNull(message = "ID can not be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Level No. can not be null")
    @Column(name = "lvl_no", unique = true, nullable = false)
    private Long lvlNo;

    @OneToMany(mappedBy = "authorizeLvl")
    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AuthorizeSignatory> authorizeSignatories;

    public AuthorizeLvl() {
    }

    public AuthorizeLvl(Long lvlNo, List<AuthorizeSignatory> authorizeSignatories) {
        this.lvlNo = lvlNo;
        this.authorizeSignatories = authorizeSignatories;
    }

    public AuthorizeLvl(Long lvlNo) {
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

}
