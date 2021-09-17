package com.example.group6project.repository;

import com.example.group6project.enums.TopicCategory;
import com.example.group6project.models.Comments;
import com.example.group6project.models.Person;
import com.example.group6project.models.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentsRepositoryTest {
    @Autowired
   private CommentsRepository underTest;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Test
    void findCommentsByTopic() {
        Topic topic1 = new Topic();
        topic1.setTopicTitle("Movies are food for the soul");
        topic1.setTopicCategory(TopicCategory.MOVIES);
        topicRepository.save(topic1);

        Person person1 = new Person();
        person1.setUsername("richie");
        personRepository.save(person1);


        Comments comments = new Comments();

        comments.setTopic(topic1);
        comments.setPerson(person1);
        comments.setCommentBody("this is beautiful");
        comments.setLocalDate(LocalDate.now());
        comments.setLocalTime(LocalTime.now());

       // underTest.save(comments);

     // List<Comments>  list1 =  underTest.findCommentsByTopic(topic1);

       // assertThat(list1).isNotNull();

    }
}