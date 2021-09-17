package com.example.group6project.service;

import com.example.group6project.models.Comments;
import com.example.group6project.models.Person;
import com.example.group6project.models.Topic;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
@Service
public interface CommentService {
    void createNewComment(HttpSession session, Person person, String commentBody);
    List<Comments> displayAllCommentsOnATopic(Long id, HttpSession session, Model model);
}
