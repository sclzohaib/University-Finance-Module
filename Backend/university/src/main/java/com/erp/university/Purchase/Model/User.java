package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "user_sequence")

    @NotNull(message = "User ID cannot be null")
    @NotEmpty(message = "User ID cannot be empty")
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Username cannot be null !!")
    @NotEmpty(message = "Username cannot be empty !!")
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 6, max = 30, message = "Username must be between  to 30 characters ")
    @Column(name = "user_name", nullable = false)
    private String name;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid ")
    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password cannot be blank ")
    @Size(min = 8, max = 13, message = "Password must be between 8 to 15 characters")
    @Column(name = "user_password", nullable = false)
    private String password;

    @NotNull(message = "Status cannot be null")
    @NotEmpty(message = "Status cannot be empty")
    @NotBlank(message = "Status cannot be blank")
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull(message = "Address cannot be null")
    @NotEmpty(message = "Address cannot be empty")
    @NotBlank(message = "Address cannot be blank")
    @Size(min = 50, max = 100, message = "Address must be between 50 to 100 characters")
    @Column(name = "User_address", unique = true, nullable = false)
    private String address;

    @NotNull(message = "Contact_no  cannot be null")
    @NotEmpty(message = "Contact_no cannot be empty")
    @Size(min = 6, max = 14, message = "Contact Number must be between 12 to 14 characters")
    @Column(name = "contact_no", unique = true, nullable = false)
    private Long contactNo;

    public User() {
    }

    public User(String name, String email, String password, String status, String address, Long contactNo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.address = address;
        this.contactNo = contactNo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }
}
