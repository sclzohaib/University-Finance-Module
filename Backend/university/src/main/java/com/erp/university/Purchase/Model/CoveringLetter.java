package com.erp.university.Purchase.Model;

import javax.persistence.*;

@Entity
public class CoveringLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "cl_seq")
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
}
