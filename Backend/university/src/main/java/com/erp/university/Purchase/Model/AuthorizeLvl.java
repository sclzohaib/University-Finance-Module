package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "lvl_auth")
public class AuthorizeLvl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence",sequenceName = "auth_lvl_seq")
    @NotNull (message= "ID can not be null")
    @NotEmpty (message = "ID can not be empty")
    @Column (name= "lvl_id", nullable = false)
    private Long id;

    @Column (name= "lvl_priority" , nullable = false)
    @NotNull (message= "Level No. can not be null")
    @NotEmpty (message = "Level No. can not be empty")
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
