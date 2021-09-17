package com.example.group6project.service;

import com.example.group6project.dto.CategoryDto;
import com.example.group6project.enums.TopicCategory;
import com.example.group6project.enums.TopicStatus;
import com.example.group6project.models.Topic;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public interface TopicService {
    void createNewTopic(CategoryDto categoryDto);
//    Pageable pages= PageRequest.of(1,10, Sort.by("timeCreated"));
    List<Topic>displayAllTopicsAvailable(TopicStatus topicStatus);
    void deleteTopic(Long id);
    List<Topic>displayTopicByCategory(TopicCategory topicCategory,TopicStatus topicStatus);
    List<Topic>displayAllSearchedTopics(String keyword);
}
