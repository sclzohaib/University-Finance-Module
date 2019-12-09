package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "auth_lvl")
public class AuthorizeLvl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "al_id_sequence_g")
    @SequenceGenerator(name = "al_id_sequence_g", sequenceName = "auth_lvl_seq")
    @NotNull(message = "ID can not be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Level No. can not be null")
    @Column(name = "lvl_no", unique = true, nullable = false)
    private Long lvlNo;

    public AuthorizeLvl() {
    }


    public AuthorizeLvl(Long lvlNo) {
        this.lvlNo = lvlNo;
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
        return "AuthorizeLvl{" +
                "id=" + id +
                ", lvlNo=" + lvlNo +
                '}';
    }
}
