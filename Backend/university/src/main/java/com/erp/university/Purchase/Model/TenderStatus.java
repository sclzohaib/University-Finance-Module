package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tender_status")
public class TenderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ts_id_sequence_g")
    @SequenceGenerator(name = "ts_id_sequence_g", sequenceName = "tender_status_seq",allocationSize=1)
    @NotNull(message = "id cannot be null !!")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "name cannot be null !!")
    @NotBlank(message = "name cannot be blank !!")
    @NotEmpty(message = "name cannot be empty")
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    public TenderStatus() {
    }

    public TenderStatus(Long id, String name) {
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

    @Override
    public String toString() {
        return "TenderStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
