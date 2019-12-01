package com.erp.university.Purchase.Model;

import javax.persistence.*;

@Entity
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "summary_seq")
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
