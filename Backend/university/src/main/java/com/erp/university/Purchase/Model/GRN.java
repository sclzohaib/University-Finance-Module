package com.erp.university.Purchase.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GRN {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "grn_seq")
    private Long id;
    private Long GrnNo;
    private Date date;
    private Date purchaseDate;
    private String status;
    private Long recievedQuantity;
    private Long totalQuantity;
    private String reasonForRejection;
    private String recievedBy;
    private String postedBy;
    private String inspectedBy;
    private String departmentHead;

    public GRN() {
    }

    public GRN(Long id, Long grnNo, Date date, Date purchaseDate, String status, Long recievedQuantity, Long totalQuantity, String reasonForRejection, String recievedBy, String postedBy, String inspectedBy, String departmentHead) {
        this.id = id;
        GrnNo = grnNo;
        this.date = date;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.recievedQuantity = recievedQuantity;
        this.totalQuantity = totalQuantity;
        this.reasonForRejection = reasonForRejection;
        this.recievedBy = recievedBy;
        this.postedBy = postedBy;
        this.inspectedBy = inspectedBy;
        this.departmentHead = departmentHead;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGrnNo() {
        return GrnNo;
    }

    public void setGrnNo(Long grnNo) {
        GrnNo = grnNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRecievedQuantity() {
        return recievedQuantity;
    }

    public void setRecievedQuantity(Long recievedQuantity) {
        this.recievedQuantity = recievedQuantity;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }

    public String getRecievedBy() {
        return recievedBy;
    }

    public void setRecievedBy(String recievedBy) {
        this.recievedBy = recievedBy;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getInspectedBy() {
        return inspectedBy;
    }

    public void setInspectedBy(String inspectedBy) {
        this.inspectedBy = inspectedBy;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }
}
