package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "covering_letter")
public class CoveringLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cl_id_sequence_g")
    @SequenceGenerator(name = "cl_id_sequence_g", sequenceName = "cl_seq")
    @NotNull(message = "ID can not be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    public CoveringLetter() {
    }

    public CoveringLetter(Long id) {
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
        return "CoveringLetter{" +
                "id=" + id +
                '}';
    }
}
