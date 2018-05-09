package com.balstaalpin.balstaalpin.resource;

import com.balstaalpin.balstaalpin.model.CourseName;
import com.balstaalpin.balstaalpin.repository.CourseNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coursenames")
public class CourseNameController {

    @Autowired
    private CourseNameRepository repository;

    @RequestMapping(
            method = RequestMethod.GET)
    public List<CourseName> getAll() {

        return repository.findAll();
    }
}