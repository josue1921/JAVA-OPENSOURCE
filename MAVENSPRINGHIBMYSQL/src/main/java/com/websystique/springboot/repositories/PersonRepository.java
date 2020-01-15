package com.websystique.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.websystique.springboot.model.Persons;

@Repository
public interface PersonRepository extends JpaRepository<Persons, Long> {

}
