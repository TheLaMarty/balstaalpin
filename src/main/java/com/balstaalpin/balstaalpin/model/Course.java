package com.balstaalpin.balstaalpin.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="course")
public class Course {

    @Id
    @Column(name = "courseid", updatable = false)
    private Integer courseid;

    @Column(name = "coursenameid")
    private Integer coursenameid;

    @Column(name = "name")
    private String name;

    @Column(name = "startdate")
    private Date startdate;

    @Column(name = "enddate")
    private Date enddate;


    protected Course() {

    }

    public Course(Integer courseid, Integer coursenameid, String name, String memberId, Date startdate, Date enddate) {
        this.courseid = courseid;
        this.coursenameid = coursenameid;
        this.name = name;
        this.startdate = startdate;
        this.enddate = enddate;
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