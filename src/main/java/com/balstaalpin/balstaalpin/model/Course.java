package com.balstaalpin.balstaalpin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "courseid")
    private Integer courseid;

    @Column(name = "coursenameid")
    private Integer coursenameid;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "startdate")
    private Date startdate;

    @Temporal(TemporalType.DATE)
    @Column(name = "enddate")
    private Date enddate;

    @JoinTable(name = "class", joinColumns = {@JoinColumn(name = "courseid")},
            inverseJoinColumns = {@JoinColumn(name = "juniorid")})
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Junior> juniors = new HashSet<>();

    protected Course() {

    }

    public Course(String name) {
        this.name = name;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCoursenameid() {
        return coursenameid;
    }

    public void setCoursenameid(Integer coursenameid) {
        this.coursenameid = coursenameid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Set<Junior> getJuniors() {
        return juniors;
    }

    public void setJuniors(Set<Junior> juniors) {
        this.juniors = juniors;
    }

    public void addJunior(Junior junior) {
        juniors.add(junior);
    }

    public void removeJunior(Junior junior) {
        juniors.remove(junior);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", name='" + name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }
}