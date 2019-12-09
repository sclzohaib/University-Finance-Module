package com.erp.university.Purchase.DTO;

public class TenVenDTO {
    private Long id;
    private String quotation;
    private String vendorEmail;
    private String vendorAddress;
    private String venNtn;
    private Long vendorNic;

    public TenVenDTO() {
    }

    public TenVenDTO(String quotation, String vendorEmail, String vendorAddress, String venNtn, Long vendorNic) {
        this.quotation = quotation;
        this.vendorEmail = vendorEmail;
        this.vendorAddress = vendorAddress;
        this.venNtn = venNtn;
        this.vendorNic = vendorNic;
    }

    public TenVenDTO(Long id, String quotation, String vendorEmail, String vendorAddress, String venNtn, Long vendorNic) {
        this.id = id;
        this.quotation = quotation;
        this.vendorEmail = vendorEmail;
        this.vendorAddress = vendorAddress;
        this.venNtn = venNtn;
        this.vendorNic = vendorNic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVenNtn() {
        return venNtn;
    }

    public void setVenNtn(String venNtn) {
        this.venNtn = venNtn;
    }

    public Long getVendorNic() {
        return vendorNic;
    }

    public void setVendorNic(Long vendorNic) {
        this.vendorNic = vendorNic;
    }

    @Override
    public String toString() {
        return "TenVenDTO{" +
                "id=" + id +
                ", quotation='" + quotation + '\'' +
                ", vendorEmail='" + vendorEmail + '\'' +
                ", vendorAddress='" + vendorAddress + '\'' +
                ", venNtn='" + venNtn + '\'' +
                ", vendorNic=" + vendorNic +
                '}';
    }
}
