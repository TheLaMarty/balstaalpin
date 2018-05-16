package com.balstaalpin.balstaalpin.resource;

import com.balstaalpin.balstaalpin.model.Junior;
import com.balstaalpin.balstaalpin.repository.JuniorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/juniors/")
public class JuniorController {

    @Autowired
    private JuniorRepository repository;

    // GET ALL JUNIORS
    @RequestMapping(
            method = RequestMethod.GET)
    public List<Junior> getAll() {
        return repository.findAll();
    }

    // CREATE NEW JUNIOR
    @PostMapping("create")
    public Junior createJunior(@Valid @RequestBody Junior junior) {
        return repository.save(junior);
    }

    // DELETE SPECIFIC JUNIOR
    @DeleteMapping("/delete/{id}")
    public void deleteJunior(@PathVariable long id) {
        repository.deleteById(id);
    }

    // RETRIEVE SPECIFIC JUNIOR BY ID
    @RequestMapping(value = "/getjunior/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Junior getJunior(@PathVariable("id") Long id) {
        Junior junior = repository.findByjuniorid(id);
        return junior;
    }

    // UPDATE LAST NAME
    @PutMapping("/student/{id}/{lastname}")
    public ResponseEntity<Object> updateStudent(@PathVariable Long id, @PathVariable String lastname) {

        Junior juniorFound = repository.findByjuniorid(id);

        juniorFound.setLastName(lastname);
        repository.save(juniorFound);
        return ResponseEntity.noContent().build();
    }
}
