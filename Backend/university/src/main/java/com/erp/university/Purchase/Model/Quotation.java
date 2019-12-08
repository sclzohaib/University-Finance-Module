package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name= "quotation")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quotation_id_sequence_g")
    @SequenceGenerator(name = "quotation_id_sequence_g", sequenceName = "quotation_seq")
    @NotNull(message = "Id cannot be null !!")
    @NotEmpty(message= "Id cannot be empty")
    @Column(name= "id", unique= true ,nullable = false)
    private Long id;

    @NotNull(message = "Ref No cannot be null")
    @NotEmpty(message= "Ref No cannot be empty")
    @Column(name= "ref_no", unique= true ,nullable = false)
    private Long refNo;

    @NotNull(message = "Date cannot be null !!")
    @NotEmpty(message = "Date cannot be empty !!")
    @PastOrPresent(message = "Date cannot be in future date")
    @Column(name= "date", nullable = false)
    private Date date;

    @NotNull(message = "Terms and Conditions cannot be null !!")
    @NotBlank(message = "Terms and Conditions cannot be blank !!")
    @NotEmpty(message= "Terms and Conditions cannot be empty")
    @Column(name= "terms_condition", nullable = false)
    private String termsCondition;

    @NotNull(message = "Total cannot be null !!")
    @NotEmpty(message= "Total cannot be empty")
    @Column(name= "total", nullable = false)
    private Long total;

    public Quotation() {
    }


    public Quotation(Long id, Long refNo, Date date, String termsCondition, Long total) {
        this.id = id;
        this.refNo = refNo;
        this.date = date;
        this.termsCondition = termsCondition;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRefNo() {
        return refNo;
    }

    public void setRefNo(Long refNo) {
        this.refNo = refNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(String termsCondition) {
        this.termsCondition = termsCondition;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
