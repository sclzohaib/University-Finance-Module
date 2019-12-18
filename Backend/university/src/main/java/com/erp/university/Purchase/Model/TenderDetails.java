package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tender_details")
public class TenderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "td_id_sequence_g")
    @SequenceGenerator(name = "td_id_sequence_g", sequenceName = "tender_details_seq")
    @NotNull(message = "tender details ID cannot be null !!")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "Description ID cannot be null !!")
    @Column(name = "description_id", nullable = false)
    private Long descriptionId;

    @NotNull(message = "description cannot be null !!")
    @NotBlank(message = "description cannot be blank !!")
    @NotEmpty(message = "description cannot be empty")
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "Quantity cannot be null !!")
    @Column(name = "qty", nullable = false)
    private Long qty;

    @NotNull(message = "unit price cannot be null !!")
    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @NotNull(message = "Total price cannot be null !!")
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    public TenderDetails() {
    }

    public TenderDetails(Long id, Long descriptionId, String description, Long qty, Double unitPrice, Double totalPrice) {
        this.id = id;
        this.descriptionId = descriptionId;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TenderDetails{" +
                "id=" + id +
                ", descriptionId=" + descriptionId +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
