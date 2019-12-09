package com.erp.university.Purchase.DTO;

public class TendorDTO {
    private Long id;
    private Long tNo;
    private String tStatus;

    public TendorDTO() {
    }

    public TendorDTO(Long id, Long tNo, String tStatus) {
        this.id = id;
        this.tNo = tNo;
        this.tStatus = tStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long gettNo() {
        return tNo;
    }

    public void settNo(Long tNo) {
        this.tNo = tNo;
    }

    public String gettStatus() {
        return tStatus;
    }

    public void settStatus(String tStatus) {
        this.tStatus = tStatus;
    }

    @Override
    public String toString() {
        return "TendorDTO{" +
                "id=" + id +
                ", tNo=" + tNo +
                ", tStatus='" + tStatus + '\'' +
                '}';
    }
}
