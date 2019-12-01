package com.erp.university.Purchase.Model;

public class AuthorizeSignatory {
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
