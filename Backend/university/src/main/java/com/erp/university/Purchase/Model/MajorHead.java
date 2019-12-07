package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "major_head")
public class MajorHead {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "major_head_seq")

    @NotNull(message = "Major head ID cannot be null")
    @NotEmpty(message = "Major head ID cannot be empty")
    @Column(name = "id" ,unique = true,nullable = false)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name",unique = false,nullable = false)
    @Size(min = 4 ,max = 50 ,message = "Major head name must be in between 11 and 13")
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
