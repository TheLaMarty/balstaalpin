package com.balstaalpin.balstaalpin.resource;

import com.balstaalpin.balstaalpin.exception.ResourceNotFoundException;
import com.balstaalpin.balstaalpin.model.Member;
import com.balstaalpin.balstaalpin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/members/")
public class MemberController {

    @Autowired
    private MemberRepository repository;

    // GET ALL MEMBERS
    @RequestMapping(
            method = RequestMethod.GET,
            value = "getall")
    public List<Member> getAll() {
        return repository.findAll();
    }

    // CREATE NEW MEMBER
    @PostMapping("/create")
    public Member createQuestion(@Valid @RequestBody Member member) {
        return repository.save(member);
    }

    // GET ALL MEMBERS BETTER VERSION
    @GetMapping("/all")
    public Page<Member> getQuestions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // GET MEMBER BY ID
    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public List<Member> getMember(@PathVariable("id") String id) {
        List<Member> members = repository.findBysocialsecuritynumber(id);
        return members;
    }

    // DELETE MEMBER BY ID
    @DeleteMapping("/get/{memberid}")
    public ResponseEntity<?> deleteMember(@PathVariable Integer memberid) {
        return repository.findById(memberid)
                .map(question -> {
                    repository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Member with id " + memberid + "not found."));
    }
}

