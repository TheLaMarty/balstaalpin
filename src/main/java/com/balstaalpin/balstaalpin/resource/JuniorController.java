package com.balstaalpin.balstaalpin.resource;

import com.balstaalpin.balstaalpin.model.Junior;
import com.balstaalpin.balstaalpin.repository.JuniorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class JuniorController {

    @Autowired
    private JuniorRepository repository;

    @RequestMapping(
            method = RequestMethod.GET)
    public List<Junior> getAll() {

        return repository.findAll();
    }
}
