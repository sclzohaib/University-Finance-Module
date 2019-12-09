package com.erp.university.Purchase.DTO;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String location;
    private Long telephone;
    private Long extensionNo;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name, String location, Long telephone, Long extensionNo) {
        this.id = id;
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

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", telephone=" + telephone +
                ", extensionNo=" + extensionNo +
                '}';
    }
}
