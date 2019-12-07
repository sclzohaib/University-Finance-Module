package com.erp.university.Purchase.Model;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Minor_head")
public class MinorHead {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "minor_head_seq")
    @NotNull(message = "Id cannot be null !!")
    @NotEmpty(message= "Id cannot be empty")
    @Column(name= "id",unique= true, nullable = false)
    private Long id;
    @NotNull(message = "Name cannot be null !!")
    @NotBlank(message = "Name cannot be blank !!")
    @NotEmpty(message= "Name cannot be empty")
    @Column(name= "name", nullable = false)
    @Size(min = 10, max = 50 , message = "Name must be between 10 and 50 characters")
    private String name;
    @NotNull(message = "codeNo cannot be null")
    @NotEmpty(message= "code No cannot be empty")
    @Column(name= "code_no",unique=true, nullable = false)
    private Long codeNo;

    public MinorHead() {
    }

    public MinorHead(Long id, String name, Long codeNo) {
        this.id = id;
        this.name = name;
        this.codeNo = codeNo;
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

    public Long getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(Long codeNo) {
        this.codeNo = codeNo;
    }
}
