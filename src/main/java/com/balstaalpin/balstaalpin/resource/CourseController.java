package com.balstaalpin.balstaalpin.resource;

import com.balstaalpin.balstaalpin.model.Course;
import com.balstaalpin.balstaalpin.model.Junior;
import com.balstaalpin.balstaalpin.repository.CourseRepository;
import com.balstaalpin.balstaalpin.repository.JuniorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private JuniorController juniorController;

    @Autowired
    private JuniorRepository juniorRepository;

    // GET ALL COURSES
    @RequestMapping(
            method = RequestMethod.GET)
    public List<Course> getAll() {
        return repository.findAll();
    }

    // CREATE NEW COURSE
    @PostMapping("/create")
    public Course createCourse(@Valid @RequestBody Course course) {
        return repository.save(course);
    }

    // DELETE SPECIFIC COURSE
    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    // RETRIEVE SPECIFIC COURSENAME BY ID
    @RequestMapping(value = "/getcourse/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Course getCourse(@PathVariable("id") Integer id) {
        Course course = repository.findBycourseid(id);
        return course;
    }

    // ADD JUNIOR TO CLASS
    @PostMapping("/{courseid}/addjunior/{juniorid}/")
    public Course updateClassList(@PathParam("courseid") Integer courseid, @PathParam("juniorid") Long juniorid) {

        Junior juniorFound = juniorRepository.findByjuniorid(juniorid);
        Course course = repository.findBycourseid(courseid);
        course.juniors.add(juniorFound);

        return repository.save(course);
    }

    @PutMapping("/add/{courseid}/{juniorid}")
    public ResponseEntity<Object> updateStudent(@PathVariable Integer courseid, @PathVariable Long juniorid) {

        Junior juniorFound = juniorRepository.findByjuniorid(juniorid);
        Course course = repository.findBycourseid(courseid);
        course.addJunior(juniorFound);
        repository.save(course);
        return ResponseEntity.noContent().build();
    }
}


