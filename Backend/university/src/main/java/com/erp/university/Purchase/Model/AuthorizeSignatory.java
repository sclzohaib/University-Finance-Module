package com.erp.university.Purchase.Model;

public class AuthorizeSignatory {
    private Long aId;
    private Long lvlId;

    public AuthorizeSignatory() {
    }

    public AuthorizeSignatory(Long aId, Long lvlId) {
        this.aId = aId;
        this.lvlId = lvlId;
    }

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public Long getLvlId() {
        return lvlId;
    }

    public void setLvlId(Long lvlId) {
        this.lvlId = lvlId;
    }
}
