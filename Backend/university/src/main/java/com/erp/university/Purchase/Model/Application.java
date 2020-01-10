package com.erp.university.Purchase.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_id_sequence_g")
    @SequenceGenerator(name = "app_id_sequence_g", sequenceName = "app_seq",allocationSize=1)
    @NotNull(message = "Application ID cannot be null")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Subject cannot be null !!")
    @NotBlank(message = "Subject cannot be blank !!")
    @NotEmpty(message = "Subject cannot be empty")
    @Size(min = 10, max = 50, message = "Subject must be between 10 and 50 characters")
    @Column(name = "subject", nullable = false)
    private String subject;

    @NotNull(message = "Date cannot be null")
    @Column(name = "app_date", nullable = false)
    private Date date;

    @NotNull(message = "Status cannot be null")
    @NotBlank(message = "Status cannot be blank !!")
    @NotEmpty(message = "Status cannot be Empty")
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull(message = "Associate Person cannot be null")
    @NotBlank(message = "Associate Person cannot be blank !!")
    @NotEmpty(message = "Associate Person cannot be Empty")
    @Column(name = "associate_person", nullable = false)
    private String associatePerson;

    public Application() {
    }

    public Application(Long id, String subject, Date date, String status, String associatePerson) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.status = status;
        this.associatePerson = associatePerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssociatePerson() {
        return associatePerson;
    }

    public void setAssociatePerson(String associatePerson) {
        this.associatePerson = associatePerson;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", associatePerson='" + associatePerson + '\'' +
                '}';
    }
}
