package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quotation_detail")
public class QuotationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qd_id_sequence_g")
    @SequenceGenerator(name = "qd_id_sequence_g", sequenceName = "qd_sequence")
    @NotNull(message = "ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Description cannot be null !!")
    @NotBlank(message = "Description cannot be blank !!")
    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @NotNull(message = "Brand cannot be null !!")
    @NotBlank(message = "Brand cannot be blank !!")
    @NotEmpty(message = "Brand cannot be empty")
    @Column(name = "brand", nullable = false)
    private String Brand;

    @NotNull(message = "Quantity cannot be null !!")
    @Column(name = "quantity", unique = true, nullable = false)
    private Long quantity;

    @NotNull(message = "Price with GST cannot be null !!")
    @Column(name = "price_with_gst", unique = true, nullable = false)
    private Long priceWithGst;

    @NotNull(message = "Total cannot be null !!")
    @Column(name = "total", unique = true, nullable = false)
    private Long total;

    @NotNull(message = "Unit Price cannot be null !!")
    @Column(name = "unit_price", unique = true, nullable = false)
    private Long unitPrice;

    public QuotationDetail() {
    }

    public QuotationDetail(Long id, String description, String brand, Long quantity, Long priceWithGst, Long total, Long unitPrice) {
        this.id = id;
        this.description = description;
        Brand = brand;
        this.quantity = quantity;
        this.priceWithGst = priceWithGst;
        this.total = total;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPriceWithGst() {
        return priceWithGst;
    }

    public void setPriceWithGst(Long priceWithGst) {
        this.priceWithGst = priceWithGst;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "QuotationDetail{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", Brand='" + Brand + '\'' +
                ", quantity=" + quantity +
                ", priceWithGst=" + priceWithGst +
                ", total=" + total +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
