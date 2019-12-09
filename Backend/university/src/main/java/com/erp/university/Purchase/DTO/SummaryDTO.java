package com.erp.university.Purchase.DTO;

public class SummaryDTO {
    private Long id;

    public SummaryDTO() {
    }

    public SummaryDTO(Long id) {
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
        return "SummaryDTO{" +
                "id=" + id +
                '}';
    }
}
