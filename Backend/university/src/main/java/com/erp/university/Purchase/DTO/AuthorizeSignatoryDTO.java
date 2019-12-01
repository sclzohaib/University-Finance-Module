package com.erp.university.Purchase.DTO;

public class AuthorizeSignatoryDTO {
    private Long id;
    private Long lvlId;


    public AuthorizeSignatoryDTO() {
    }

    public AuthorizeSignatoryDTO(Long id, Long lvlId) {
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
