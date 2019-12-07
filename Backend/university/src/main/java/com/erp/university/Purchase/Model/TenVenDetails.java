package com.erp.university.Purchase.Model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "tenvendetails")
public class TenVenDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "ten_ven_details_seq")
    @NotNull(message = "ID cannot be null")
    @NotEmpty(message = "ID cannot be empty")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Quotation cannot be null !!")
    @NotBlank(message = "Quotation cannot be blank !!")
    @NotEmpty(message = "Quotation cannot be empty")
    @Column(name = "quotation", unique = true, nullable = false)
    private String quotation;

    @NotNull(message = "Email address cannot be null !!")
    @NotBlank(message = "Email address cannot be blank !!")
    @NotEmpty(message = "Email address cannot be empty")
    @Email(message ="Email should be valid")
    @Column(name = "vendor_email", unique = true, nullable = false)
    private String vendorEmail;

    @NotNull(message = "Vendor Address cannot be null !!")
    @NotBlank(message = "Vendor Address cannot be blank !!")
    @NotEmpty(message = "Vendor Address cannot be empty")
    @Column(name = "vendor_address" ,unique = true, nullable = false)
    private String vendorAddress;

    @NotNull(message = "VenNtn cannot be null !!")
    @NotBlank(message = "VenNtn cannot be blank !!")
    @NotEmpty(message = "VenNtn cannot be empty")
    @Column(name = "ven_ntn" ,unique = true, nullable = false)
    private String venNtn;

    @NotNull(message = "Vendor NIC cannot be null !!")
    @NotBlank(message = "Vendor NIC cannot be blank !!")
    @NotEmpty(message = "Vendor NIC cannot be empty")
    @Column(name = "vendor_nic" ,unique = true, nullable = false)
    private Long vendorNic;


    public TenVenDetails() {
    }

    public TenVenDetails(String quotation, String vendorEmail, String vendorAddress, String venNtn, Long vendorNic) {
        this.quotation = quotation;
        this.vendorEmail = vendorEmail;
        this.vendorAddress = vendorAddress;
        this.venNtn = venNtn;
        this.vendorNic = vendorNic;
    }

    public TenVenDetails(Long id, String quotation, String vendorEmail, String vendorAddress, String venNtn, Long vendorNic) {
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
}
