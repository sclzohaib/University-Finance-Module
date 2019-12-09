package com.erp.university.Purchase.DTO;

public class CoveringLetterDTO {
    private Long id;

    public CoveringLetterDTO() {
    }

    public CoveringLetterDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CoveringLetterDTO{" +
                "id=" + id +
                '}';
    }
}
