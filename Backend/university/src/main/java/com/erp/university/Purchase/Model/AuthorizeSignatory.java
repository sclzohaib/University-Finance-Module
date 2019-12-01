package com.erp.university.Purchase.Model;

import javax.persistence.*;

@Entity
public class AuthorizeSignatory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "auth_sign_seq")
    private Long id;
    private Long lvlId;

    public AuthorizeSignatory() {
    }

    public AuthorizeSignatory(Long id, Long lvlId) {
        this.id = id;
        this.lvlId = lvlId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLvlId() {
        return lvlId;
    }

    public void setLvlId(Long lvlId) {
        this.lvlId = lvlId;
    }
}
