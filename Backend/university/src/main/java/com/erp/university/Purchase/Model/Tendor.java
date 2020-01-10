package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tendor")
public class Tendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tendor_id_sequence_g")
    @SequenceGenerator(name = "tendor_id_sequence_g", sequenceName = "tendor_seq",allocationSize=1)
    @NotNull(message = "Tendor ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Tendor No. cannot be null")
    @Column(name = "t_no", unique = true, nullable = false)
    private Long tNo;

    @NotNull(message = "Tendor status cannot be null")
    @NotEmpty(message = "Tendor status cannot be empty")
    @NotBlank(message = "Tendor status cannot be blank !!")
    @Column(name = "t_status", nullable = false)
    private String tStatus;

    public Tendor() {
    }

    public Tendor(Long id, Long tNo, String tStatus) {
        this.id = id;
        this.tNo = tNo;
        this.tStatus = tStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long gettNo() {
        return tNo;
    }

    public void settNo(Long tNo) {
        this.tNo = tNo;
    }

    public String gettStatus() {
        return tStatus;
    }

    public void settStatus(String tStatus) {
        this.tStatus = tStatus;
    }

    @Override
    public String toString() {
        return "Tendor{" +
                "id=" + id +
                ", tNo=" + tNo +
                ", tStatus='" + tStatus + '\'' +
                '}';
    }
}
