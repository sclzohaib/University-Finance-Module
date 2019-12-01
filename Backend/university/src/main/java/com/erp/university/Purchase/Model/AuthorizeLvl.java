package com.erp.university.Purchase.Model;

import javax.persistence.*;

@Entity
public class AuthorizeLvl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence",sequenceName = "auth_lvl_seq")
    private Long id;
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
}
