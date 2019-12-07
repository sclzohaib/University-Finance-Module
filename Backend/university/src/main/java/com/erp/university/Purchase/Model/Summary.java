package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Summary")
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "summary_seq")
    @NotNull(message = "Summary ID cannot be null")
    @NotEmpty(message = "Summary ID cannot be empty")
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
}
