package com.example.group6project.service.impl;

import com.example.group6project.models.Comments;
import com.example.group6project.models.Person;
import com.example.group6project.models.Topic;
import com.example.group6project.repository.CommentsRepository;
import com.example.group6project.repository.TopicRepository;
import com.example.group6project.service.CommentService;
import com.example.group6project.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentService {
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private TopicRepository topicRepository;


    @Override
    public void createNewComment(HttpSession session, Person person,String commentBody) {
//        Topic topic = topicRepository.findTopicById(id);
        Topic topic = (Topic) session.getAttribute("topic");
        LocalDate localDate= LocalDate.now();
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime= LocalDateTime.now();
        Comments comments= new Comments();
        comments.setPerson(person);
        comments.setTopic(topic);
        comments.setCommentBody(commentBody);
        comments.setLocalTime(localTime);
        comments.setLocalDate(localDate);
        comments.setTopic(topic);
        comments.setLocalDateTime(localDateTime);
        commentsRepository.save(comments);
    }



    public List<Comments> displayAllCommentsOnATopic(Long id, HttpSession session, Model model) {
        Topic topic = topicRepository.findTopicById(id);
        session.setAttribute("topic",topic);
        model.addAttribute("topic",topic);
        return commentsRepository.findALLByTopicOrderByLocalDateTimeDesc(topic);
    }
}
