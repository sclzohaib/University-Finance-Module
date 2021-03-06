package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_id_sequence_g")
    @SequenceGenerator(name = "po_id_sequence_g", sequenceName = "po_seq",allocationSize=1)
    @NotNull(message = "Id cannot be null !!")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Date cannot be null !!")
    @PastOrPresent(message = "date cannot be in future")
    @Column(name = "po_date", nullable = false)
    private Date date;

    @NotNull(message = "Purchase Order No cannot be null")
    @Column(name = "purchase_order_no", unique = true, nullable = false)
    private Long purchaseOrderNo;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Long id, Date date, Long purchaseOrderNo) {
        this.id = id;
        this.date = date;
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(Long purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", date=" + date +
                ", purchaseOrderNo=" + purchaseOrderNo +
                '}';
    }
}
