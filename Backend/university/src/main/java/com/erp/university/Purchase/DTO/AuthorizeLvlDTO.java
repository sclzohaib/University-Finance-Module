package com.erp.university.Purchase.DTO;

public class AuthorizeLvlDTO {
    private Long lvlNo;

    public AuthorizeLvlDTO() {
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
}
