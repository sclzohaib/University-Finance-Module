package com.erp.university.Purchase.Model;

import javax.persistence.*;

@Entity
public class QuotationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "qd_sequence")
    private Long id;
    private String description;
    private String Brand;
    private Long quantity;
    private Long priceWithGst;
    private Long total;
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
}
