package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "authorize_signatory")
public class AuthorizeSignatory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "auth_sign_seq")
    @NotNull(message = "Authorize signatory Id can not be null")
    @NotEmpty(message = "Authorize signatory Id can not be empty")
    @Column (name = "a_id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Level Id can not be null")
    @NotEmpty(message = "Level Id can not be empty")
    @Column (name = "lvl_id", nullable = false)
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
