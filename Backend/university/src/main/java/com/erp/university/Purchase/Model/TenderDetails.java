package com.erp.university.Purchase.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TenderDetails")
public class TenderDetails {

    @NotNull(message = "tender details ID cannot be null !!")
    @Column(name = "tenderDEtailsId", nullable = false, unique = true)
    private Long tenderDetailId;

    @NotNull(message = "Description ID cannot be null !!")
    @Column(name = "descriptionId" , nullable = false)
    private Long descriptionId;

    @NotNull(message = "description cannot be null !!")
    @NotBlank(message = "description cannot be blank !!")
    @NotEmpty(message = "description cannot be empty")
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "Quantity cannot be null !!")
    @Column(name = "qty" , nullable = false)
    private Long qty;

    @NotNull(message = "unit price cannot be null !!")
    @Column(name = "unitPrice", nullable = false)
    private Double unitPrice;

    @NotNull(message = "Total price cannot be null !!")
    @Column(name = "totalPrice", nullable = false)
    private Double totalPrice;

    public TenderDetails() {
    }

    public TenderDetails(Long tenderDetailId, Long descriptionId, String description, Long qty, Double unitPrice, Double totalPrice) {
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
