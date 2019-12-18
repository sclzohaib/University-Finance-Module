package com.erp.university.Purchase.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_id_sequence_g")
    @SequenceGenerator(name = "dept_id_sequence_g", sequenceName = "dept_seq")
    @NotNull(message = "Department ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Department name cannot be null")
    @NotBlank(message = "Department name cannot be blank")
    @NotEmpty(message = "Department name cannot be empty")
    @Size(min = 4, max = 30, message = "Department name must be in between 4 and 30")
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @NotNull(message = "Department location cannot be null")
    @NotBlank(message = "Department location cannot be blank")
    @NotEmpty(message = "Department location cannot be empty")
    @Column(name = "location", nullable = false)
    @Size(min = 10, max = 100, message = "Department location must be in between 10 and 100")
    private String location;

    @NotNull(message = "Department telephone No. cannot be null")
    @Size(min = 11, max = 13, message = "Department telephone No. must be in between 11 and 13")
    @Column(name = "telephone", unique = true, nullable = false)
    private Long telephone;

    @NotNull(message = "Department extension No. cannot be null")
    @Min(value = 2, message = "Department extension No. cannot be less than 2")
    @Max(value = 5, message = "Department extension No. cannot be greater than 5")
    @Column(name = "extension_no", unique = true)
    private Long extensionNo;

    @NotNull(message = "university cannot be null")
    @ManyToOne
    @JoinColumn(name = "uni_id", nullable = false)
    @JsonBackReference
    private University university;

    @OneToMany(mappedBy = "department")
    private List<User> users;

    public Department() {
    }

    public Department(String name, String location, Long telephone, Long extensionNo, University university, List<User> users) {
        this.name = name;
        this.location = location;
        this.telephone = telephone;
        this.extensionNo = extensionNo;
        this.university = university;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public Long getExtensionNo() {
        return extensionNo;
    }

    public void setExtensionNo(Long extensionNo) {
        this.extensionNo = extensionNo;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", telephone=" + telephone +
                ", extensionNo=" + extensionNo +
                ", university=" + university +
                ", users=" + users +
                '}';
    }
}
