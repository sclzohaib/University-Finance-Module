package com.erp.university.Purchase.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_type_id_sequence_g")
    @SequenceGenerator(name = "user_type_id_sequence_g", sequenceName = "user_type_seq",allocationSize=1)
    @NotNull(message = "ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "User Type cannot be null")
    @NotEmpty(message = "User Type cannot be empty")
    @NotBlank(message = "User Type cannot be blank")
    @Column(name = "user_type", nullable = false)
    private String userType;

    @OneToMany(mappedBy = "userType")
    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users;
    public UserType() {
    }

    public UserType(Long id, String userType,List<User> users) {
        this.id = id;
        this.userType = userType;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
