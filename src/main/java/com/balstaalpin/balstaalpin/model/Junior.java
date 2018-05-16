package com.balstaalpin.balstaalpin.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.sql.Date;

@Transactional
@Entity
@Table(name = "junior")
public class Junior {

    @Id
    @GeneratedValue
    @Column(name = "juniorid")
    private Long juniorid;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "memberid")
    private Integer memberid;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "createdat", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    protected Junior() {

    }

    public Junior(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Junior(String firstName, String lastName, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return juniorid;
    }

    public void setId(Long id) {
        this.juniorid = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getJuniorid() {
        return juniorid;
    }

    public void setJuniorid(Long juniorid) {
        this.juniorid = juniorid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return String.format(firstName + " " + lastName);
    }
}
