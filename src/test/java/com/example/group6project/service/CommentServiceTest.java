package com.example.group6project.service;

import com.example.group6project.enums.TopicCategory;
import com.example.group6project.enums.TopicStatus;
import com.example.group6project.models.Comments;
import com.example.group6project.models.Person;
import com.example.group6project.models.Topic;
import com.example.group6project.repository.CommentsRepository;
import com.example.group6project.repository.PersonRepository;
import com.example.group6project.repository.TopicRepository;
import com.example.group6project.service.impl.CommentsServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CommentServiceTest {
    @Mock private CommentService underTest;
    private AutoCloseable closeable;
    private TopicRepository topicRepository;
    private PersonRepository personRepository;


    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


    @Test
    void createNewComment() {
        Topic topic = new Topic();
        topic.setTopicTitle("Sports battle");
        topic.setTopicCategory(TopicCategory.SPORTS);
        topic.setTopicStatus(TopicStatus.NOT_DELETED);
        topic.setDateCreated(LocalDate.now());
        topic.setTimeCreated(LocalTime.now());
         topicRepository.save(topic);

        Person person = new Person();
        person.setUsername("Derek");
        personRepository.save(person);


//        underTest.createNewComment(
//                topic,
//                person,
//                "Arsenal is wack"
//
//        );
      //verify(underTest).createNewComment(topic,person,"Arsenal is wack");


    }

    @Test
    void displayAllCommentsOnATopic() {
    }
}