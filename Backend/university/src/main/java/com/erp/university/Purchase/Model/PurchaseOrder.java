package com.erp.university.Purchase.Model;

import java.util.Date;

public class PurchaseOrder {

    private Long id;
    private Date date;
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
}
