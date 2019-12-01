package com.erp.university.Purchase.Model;

import javax.persistence.*;

@Entity
public class GST {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "gst_seq")
    private Long id;
    private Double percent;

    public GST() {
    }

    public GST(Long id, Double percent) {
        this.id = id;
        this.percent = percent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }
}
