package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "minor_head")
public class MinorHead {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "min_h_id_sequence_g")
    @SequenceGenerator(name = "min_h_id_sequence_g", sequenceName = "minor_head_seq",allocationSize=1)
    @NotNull(message = "Id cannot be null !!")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Name cannot be null !!")
    @NotBlank(message = "Name cannot be blank !!")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 10 and 50 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "code No cannot be null")
    @Column(name = "code_no", unique = true, nullable = false)
    private Long codeNo;

    @NotNull(message = "Major Head cannot be null")
    @ManyToOne
    @JoinColumn(name = "major_head_id", nullable = false)

    private MajorHead majorHead;

    public MinorHead() {
    }

    public MinorHead(Long id, String name, Long codeNo, MajorHead majorHead) {
        this.id = id;
        this.name = name;
        this.codeNo = codeNo;
        this.majorHead = majorHead;
    }

    public MajorHead getMajorHead() {
        return majorHead;
    }

    public void setMajorHead(MajorHead majorHead) {
        this.majorHead = majorHead;
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
