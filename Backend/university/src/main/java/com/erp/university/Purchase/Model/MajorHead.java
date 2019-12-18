package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "major_head")
public class MajorHead {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mh_id_sequence_g")
    @SequenceGenerator(name = "mh_id_sequence_g", sequenceName = "major_head_seq")
    @NotNull(message = "Major head ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name", nullable = false)
    @Size(min = 4, max = 50, message = "Major head name must be in between 11 and 13")
    private String name;

    @OneToMany(mappedBy = "majorHead")
    private List<MinorHead> minorHeads;

    public MajorHead() {
    }

    public MajorHead(Long id, String name, List<MinorHead> minorHeads) {
        this.id = id;
        this.name = name;
        this.minorHeads = minorHeads;
    }

    public List<MinorHead> getMinorHeads() {
        return minorHeads;
    }

    public void setMinorHeads(List<MinorHead> minorHeads) {
        this.minorHeads = minorHeads;
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

    @Override
    public String toString() {
        return "MajorHead{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minorHeads=" + minorHeads +
                '}';
    }
}
