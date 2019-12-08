package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uni_id_sequence_g")
    @SequenceGenerator(name = "uni_id_sequence_g", sequenceName = "uni_seq")
    @NotNull(message = "University ID cannot be null")
    @NotEmpty(message = "University ID cannot be blank")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Name cannot be null !!")
    @NotBlank(message = "Name cannot be blank !!")
    @NotEmpty(message = "Name cannot be blank")
    @Size(min = 5, max = 30, message = "Name must be between 5 and 30 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Location cannot be null")
    @NotEmpty(message = "Location cannot be empty")
    @Size(min = 30, max = 100, message ="Location must be between 30 to 100 characters")
    @Column(name = "location", unique = true, nullable = false)
    private String location;

    public University() {
    }

    public University(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
