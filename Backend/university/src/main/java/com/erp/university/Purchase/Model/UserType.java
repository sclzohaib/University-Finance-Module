package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_type_id_sequence_g")
    @SequenceGenerator(name = "user_type_id_sequence_g", sequenceName = "user_type_seq")
    @NotNull(message = "ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "User Type cannot be null")
    @NotEmpty(message = "User Type cannot be empty")
    @NotBlank(message = "User Type cannot be blank")
    @Column(name = "user_type", nullable = false)
    private String userType;

    public UserType() {
    }

    public UserType(Long id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
