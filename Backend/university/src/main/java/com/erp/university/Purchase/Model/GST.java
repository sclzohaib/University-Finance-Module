package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gst")
public class GST {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gst_id_sequence_g")
    @SequenceGenerator(name = "gst_id_sequence_g", sequenceName = "gst_seq")
    @NotNull(message = "GST ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Percent cannot be null")
    @Column(name = "percent", nullable = false)
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

    @Override
    public String toString() {
        return "GST{" +
                "id=" + id +
                ", percent=" + percent +
                '}';
    }
}
