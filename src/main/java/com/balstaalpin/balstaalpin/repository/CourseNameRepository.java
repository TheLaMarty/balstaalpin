package com.balstaalpin.balstaalpin.repository;

import com.balstaalpin.balstaalpin.model.CourseName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface CourseNameRepository extends JpaRepository<CourseName, Integer> {

    List<CourseName> findByName(String name);


}