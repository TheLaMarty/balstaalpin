package com.balstaalpin.balstaalpin.model;

import javax.persistence.*;

@Entity
@Table(name = "coursename")
public class CourseName {

    @Id
    @SequenceGenerator(name = "CourseName_courseid_seq",
            sequenceName = "CourseName_courseid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CourseName_courseid_seq")
    @Column(name = "coursenameid", updatable = false)
    private Integer coursenameid;

    @Column(name = "name")
    private String name;

    public CourseName() {
    }

    public CourseName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "CourseName{" +
                ", name='" + name + '\'' +
                '}';
    }
}
