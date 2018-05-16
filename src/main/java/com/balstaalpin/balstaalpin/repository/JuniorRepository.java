package com.balstaalpin.balstaalpin.repository;

import com.balstaalpin.balstaalpin.model.Junior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JuniorRepository extends JpaRepository<Junior, Long> {

    Junior findByFirstName(String firstName);

    Junior findByLastName(String lastName);

    Junior findByjuniorid(Long juniorid);

}
