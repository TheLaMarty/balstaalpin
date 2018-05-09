package com.balstaalpin.balstaalpin.resource;

import com.balstaalpin.balstaalpin.model.Member;
import com.balstaalpin.balstaalpin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberRepository repository;

    @RequestMapping(
            method = RequestMethod.GET)
    public List<Member> getAll() {

        return repository.findAll();
    }
}

