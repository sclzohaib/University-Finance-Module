package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table (name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "dept_seq")
    @NotNull(message = "Department ID cannot be null")
    @NotEmpty(message = "Department ID cannot be empty")
    @Column(name = "id" ,unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Department name cannot be null")
    @NotEmpty(message = "Department name cannot be null")
    @Size(min = 4 ,max = 30 , message = "Departmnet name must be in between 4 and 30")
    @Column(name = "name", unique = true ,nullable = false)
    private String name;

    @NotNull(message = "Department location cannot be null")
    @NotEmpty(message = "Department location cannot be empty")
    @Column(name = "location" ,unique = true, nullable = false)
    @Size(min = 10 ,max = 100 ,message = "Department location must be in between 10 and 100")
    private String location;

    @NotNull(message = "Department telephone No. cannot be null")
    @NotEmpty(message = "Department telephone No. cannot be empty")
    @Column(name = "telephone" ,unique = true, nullable = false)
    @Size(min = 11 ,max = 13 ,message = "Department telephone No. must be in between 11 and 13")
    private Long telephone;


    @NotEmpty(message = "Department extension no. cannot be empty")
    @Min ( value  =2 ,message = "Department extention no. cannot be less than 2")
    @Max(value = 5 ,message = "Department extension no. cannot be greater than 5")
    @Column (name = "extension_no" ,unique = false ,nullable = true)
    private Long extensionNo;

    public Department() {
    }

    public Department(String name, String location, Long telephone, Long extensionNo) {
        this.name = name;
        this.location = location;
        this.telephone = telephone;
        this.extensionNo = extensionNo;
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
}
