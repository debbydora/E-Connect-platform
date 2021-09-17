package com.example.group6project.repository;

import com.example.group6project.enums.TopicCategory;
import com.example.group6project.enums.TopicStatus;
import com.example.group6project.models.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class TopicRepositoryTest {
    @Autowired
    private TopicRepository topicRepository;

    @Test
    void findTopicsByTopicStatus() {
        Topic topic = new Topic();
        topic.setTopicTitle("Aquaman, the movie");
        topic.setTopicStatus(TopicStatus.DELETED);
       // topicRepository.save(topic);

        //List<Topic> thisTopic = topicRepository.findTopicsByTopicStatus(topic.getTopicStatus());
       // List<Topic> thisTopic =topicRepository.findTopicsByTopicStatus(TopicStatus.NOT_DELETED);

       // assertThat(thisTopic).isNotNull();
        //it is not null because deleting a topic from the forum doesn't mean it has been deleted from the database.



    }

    @Test
    void findTopicById() {
        Topic topic1 = new Topic();
        topic1.setTopicTitle("Biker shorts; a trend or menance?");
        topic1.setTopicCategory(TopicCategory.FASHION);
        topic1.setTopicStatus(TopicStatus.NOT_DELETED);
        topic1.setTimeCreated(LocalTime.now());
        topic1.setDateCreated(LocalDate.now());
       // topicRepository.save(topic1);




       Topic topic = topicRepository.findTopicById(topic1.getId());
        assertThat(topic).isNotNull();

    }

    @Test
    void findTopicsByTopicStatusAndTopicCategory() {
        Topic topic2 = new Topic();
        topic2.setTopicCategory(TopicCategory.MUSIC);
        topic2.setTopicStatus(TopicStatus.DELETED);


        List<Topic> thisList = topicRepository.findTopicsByTopicStatusAndTopicCategory(topic2.getTopicStatus(),topic2.getTopicCategory());
        assertThat(thisList).isNotNull();
    }
}