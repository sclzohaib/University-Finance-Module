package com.erp.university.Purchase.Model;

import javax.persistence.*;

@Entity
public class MajorHead {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "major_head_seq")
    private Long id;
    private String name;

    public MajorHead() {
    }

    public MajorHead(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
