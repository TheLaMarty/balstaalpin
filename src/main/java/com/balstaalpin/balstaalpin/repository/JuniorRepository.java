package com.balstaalpin.balstaalpin.repository;

import com.balstaalpin.balstaalpin.model.Junior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface JuniorRepository extends JpaRepository<Junior, Integer> {

    List<Junior> findByFirstName(String firstName);

    Junior findByLastName(String lastName);
}
