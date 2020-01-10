package com.erp.university.Revenue.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Revenue_Head")
public class RevenueHead {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rev_head_id_sequence_g")
    @SequenceGenerator(name = "rev_head_id_sequence_g", sequenceName = "revenue_head_id_seq",allocationSize=1)
    @NotNull(message = "Id cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotBlank(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Name cannot be null")
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @NotNull(message = "Code cannot be null")
    @NotEmpty(message = "Code cannot be empty")
    @NotBlank(message = "Code cannot be blank")
    @Column(name = "code", unique = true, nullable = false)
    private Long code;

    public RevenueHead() {
    }

    public RevenueHead(Long id, String name, Long code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RevenueHead{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
