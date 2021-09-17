package com.example.group6project.repository;

import com.example.group6project.models.Comments;
import com.example.group6project.models.Topic;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
    List<Comments> findALLByTopicOrderByLocalDateTimeDesc(Topic topic);
}
