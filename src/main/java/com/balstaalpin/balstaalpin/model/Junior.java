package com.balstaalpin.balstaalpin.model;

import javax.persistence.*;

@Entity
@Table(name = "junior")
public class Junior {

    @JoinTable(
            name = "class",
            joinColumns = @JoinColumn(name = "juniorid", referencedColumnName = "juniorid"),
            inverseJoinColumns = @JoinColumn(name = "course", referencedColumnName = "courseid"))

    @Id
    @SequenceGenerator(name = "junior_juniorId_seq",
            sequenceName = "junior_juniorId_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "junior_juniorId_seq")
    @Column(name = "juniorid", updatable = false)
    private Integer juniorId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberid", nullable = false)
    private Member memberid;

    protected Junior() {

    }

    public Junior(String firstName, String lastName, Member memberid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberid = memberid;
    }

    public Integer getId() {
        return juniorId;
    }

    public void setId(Integer id) {
        this.juniorId = id;
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

    public Integer getJuniorId() {
        return juniorId;
    }

    public void setJuniorId(Integer juniorId) {
        this.juniorId = juniorId;
    }

    public Member getMemberid() {
        return memberid;
    }

    public void setMemberid(Member memberid) {
        this.memberid = memberid;
    }

    @Override
    public String toString() {
        return String.format(firstName + " " + lastName);
    }

}
