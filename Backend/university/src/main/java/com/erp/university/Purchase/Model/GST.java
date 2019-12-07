package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "gst")
public class GST {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "gst_seq")

    @NotNull(message = "GST ID cannot be null")
    @NotEmpty(message = "GST ID cannot be empty")
    @Column (name = "id",unique = true,nullable = false)
    private Long id;

    @NotNull(message = "Percent cannot be null")
    @NotEmpty(message = "Percent cannot be empty")
    @NotBlank(message = "Percent cannot be blank")
    @Column (name = "id",unique = false,nullable = false)
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
