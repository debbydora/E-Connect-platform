package com.example.group6project.repository;

import com.example.group6project.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;

    @Test
    void findByUsername() {
        Person person = new Person();
        person.setUsername("chocolate");
        person.setEmail("chocolate@gmail.com");
        person.setFirstName("Diane");
        person.setLastName("Briggs");
        person.setPassword("diane1");
       // person.setUserType("user");

        personRepository.save(person);

       // Optional<Person> person1 = personRepository.findByUsername("chocolate");

       // assertThat(person1).isNotNull();
        //assertThat(person1).isNull();

    }
}