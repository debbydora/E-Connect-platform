package com.example.group6project.repository;

import com.example.group6project.enums.TopicCategory;
import com.example.group6project.enums.TopicStatus;
import com.example.group6project.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {
    List<Topic> findAllByTopicStatusOrderByLocalDateTimeDesc(TopicStatus topicStatus);
    Topic findTopicById(Long id);
    List<Topic>findTopicsByTopicStatusAndTopicCategory(TopicStatus topicStatus, TopicCategory topicCategory);

    @Override
    Optional<Topic> findById(Long id);

//    @Query(value="select * from Topic t where t.topic_title LIKE %:keyword% ",nativeQuery = true)
    List<Topic> findTopicByTopicTitleContaining(String keyword);
}
