package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "grn")
public class GRN {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grn_id_sequence_g")
    @SequenceGenerator(name = "grn_id_sequence_g", sequenceName = "grn_seq")
    @NotNull(message = "GRN id cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "GRN No. cannot be null")
    @Column(name = "grn_no", unique = true, nullable = false)
    private Long GrnNo;

    @NotNull(message = "Date cannot be null")
    @Column(name = "grn_date", nullable = false)
    private Date date;

    @NotNull(message = "Date cannot be null")
    @Column(name = "purchase_date", nullable = false)
    private Date purchaseDate;

    @NotNull(message = "Status cannot be null")
    @NotEmpty(message = "Status cannot be empty")
    @NotBlank(message = "Status cannot be blank")
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull(message = "Recieved quantity cannot be null")
    @Column(name = "recieved_quantity", nullable = false)
    private Long recievedQuantity;

    @NotNull(message = "Total quantity cannot be null")
    @Column(name = "total_quantity", nullable = false)
    private Long totalQuantity;

    @NotNull(message = "Reason for rejection cannot be Null")
    @NotBlank(message = "Reason for rejection cannot be blank")
    @NotEmpty(message = "Reason for rejection cannot be Empty")
    @Column(name = "reason_for_rejection")
    private String reasonForRejection;

    @NotNull(message = "Recieved by cannot be null")
    @NotEmpty(message = "Recieved by cannot be empty")
    @NotBlank(message = "Recieved by cannot be blank")
    @Column(name = "recieved_by", nullable = false)
    private String recievedBy;

    @NotNull(message = "Posted by cannot be null")
    @NotEmpty(message = "Posted by cannot be empty")
    @NotBlank(message = "Posted by cannot be blank")
    @Column(name = "posted_by", nullable = false)
    private String postedBy;

    @NotNull(message = "Inspected by cannot be null")
    @NotEmpty(message = "Inspected by cannot be empty")
    @NotBlank(message = "Inspected by cannot be blank")
    @Column(name = "inspected_by", nullable = false)
    private String inspectedBy;

    @NotNull(message = "Department head cannot be null")
    @NotEmpty(message = "Department head cannot be empty")
    @NotBlank(message = "Department head cannot be blank")
    @Column(name = "department_head", nullable = false)
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
