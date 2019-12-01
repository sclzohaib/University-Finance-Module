package com.erp.university.Purchase.DTO;

public class AuthorizeLvlDTO {
    private Long id;
    private Long lvlNo;

    public AuthorizeLvlDTO() {
    }

    public AuthorizeLvlDTO(Long id, Long lvlNo) {
        this.id = id;
        this.lvlNo = lvlNo;
    }

    public AuthorizeLvlDTO(Long lvlNo) {
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
