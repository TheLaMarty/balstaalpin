package com.balstaalpin.balstaalpin.repository;

import com.balstaalpin.balstaalpin.model.Course;
import com.balstaalpin.balstaalpin.model.Junior;
import com.balstaalpin.balstaalpin.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByName(String name);

}