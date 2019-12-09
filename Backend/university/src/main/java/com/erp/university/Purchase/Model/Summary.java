package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Summary")
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "summary_id_sequence_g")
    @SequenceGenerator(name = "summary_id_sequence_g", sequenceName = "summary_seq")
    @NotNull(message = "Summary ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    public Summary() {
    }

    public Summary(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id=" + id +
                '}';
    }
}
