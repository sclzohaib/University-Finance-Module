package com.erp.university.Purchase.Model;

import javax.persistence.*;

@Entity
public class Tendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "tendor_seq")
    private Long id;
    private Long tNo;
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
}
