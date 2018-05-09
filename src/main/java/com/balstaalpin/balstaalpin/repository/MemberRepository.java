package com.balstaalpin.balstaalpin.repository;

import com.balstaalpin.balstaalpin.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findByFirstName(String firstName);

    Member findByLastName(String lastName);
}

