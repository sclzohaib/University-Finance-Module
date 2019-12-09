package com.erp.university.Purchase.DTO;

public class GSTDTO {
    private Long id;
    private Double percent;

    public GSTDTO() {
    }

    public GSTDTO(Long id, Double percent) {
        this.id = id;
        this.percent = percent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "GSTDTO{" +
                "id=" + id +
                ", percent=" + percent +
                '}';
    }
}
