package com.balstaalpin.balstaalpin.resource;

import com.balstaalpin.balstaalpin.model.Course;
import com.balstaalpin.balstaalpin.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @RequestMapping(
            method = RequestMethod.GET)
    public List<Course> getAll() {

        return repository.findAll();
    }
}


