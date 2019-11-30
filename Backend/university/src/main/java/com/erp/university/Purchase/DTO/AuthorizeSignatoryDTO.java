package com.erp.university.Purchase.DTO;

public class AuthorizeSignatoryDTO {
    private Long aId;
    private Long lvlId;

    public AuthorizeSignatoryDTO() {
    }

    public AuthorizeSignatoryDTO(Long aId, Long lvlId) {
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
