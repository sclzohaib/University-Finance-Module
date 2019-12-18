package com.erp.university.Purchase.DTO;

public class TenderDetailsDTO {
    private Long tenderDetailId;
    private Long descriptionId;
    private String description;
    private Long qty;
    private Double unitPrice;
    private Double totalPrice;

    public TenderDetailsDTO() {
    }

    public TenderDetailsDTO(Long tenderDetailId, Long descriptionId, String description, Long qty, Double unitPrice, Double totalPrice) {
        this.tenderDetailId = tenderDetailId;
        this.descriptionId = descriptionId;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public Long getTenderDetailId() {
        return tenderDetailId;
    }

    public void setTenderDetailId(Long tenderDetailId) {
        this.tenderDetailId = tenderDetailId;
    }

    public Long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Long descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
