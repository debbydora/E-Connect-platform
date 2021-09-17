package com.example.group6project.service.impl;

import com.example.group6project.dto.CategoryDto;
import com.example.group6project.enums.TopicCategory;
import com.example.group6project.enums.TopicStatus;
import com.example.group6project.models.Topic;
import com.example.group6project.repository.TopicRepository;
import com.example.group6project.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Override
    public void createNewTopic(CategoryDto categoryDto) {

        Topic topic1= new Topic();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime= LocalDateTime.now();
        topic1.setTopicStatus(TopicStatus.NOT_DELETED);
        topic1.setTopicTitle(categoryDto.getTopicTitle());
        topic1.setTopicCategory(categoryDto.getTopicCategory());
        topic1.setDateCreated(localDate);
        topic1.setTimeCreated(localTime);
        topic1.setLocalDateTime(localDateTime);
        topicRepository.save(topic1);
    }

    @Override
    public List<Topic> displayTopicByCategory(TopicCategory topicCategory,TopicStatus topicStatus) {
        return topicRepository.findTopicsByTopicStatusAndTopicCategory(topicStatus,topicCategory);
    }

    @Override
    public List<Topic> displayAllTopicsAvailable(TopicStatus topicStatus) {
        return topicRepository.findAllByTopicStatusOrderByLocalDateTimeDesc(TopicStatus.NOT_DELETED);
    }

    @Override
    public void deleteTopic(Long id) {
        Topic topic1=topicRepository.findTopicById(id);
        topic1.setTopicStatus(TopicStatus.DELETED);
        topicRepository.save(topic1);
    }

    @Override
    public List<Topic> displayAllSearchedTopics(String keyword) {
        return topicRepository.findTopicByTopicTitleContaining(keyword);
    }
}
