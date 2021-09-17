package com.example.group6project.repository;

import com.example.group6project.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person getPersonByEmailAndPassword(String email,String password);
}
