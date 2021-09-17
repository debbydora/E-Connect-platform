package com.example.group6project.controller;

import com.example.group6project.enums.TopicStatus;
import com.example.group6project.enums.UserType;
import com.example.group6project.models.Comments;
import com.example.group6project.models.Person;
import com.example.group6project.models.Topic;
import com.example.group6project.service.CommentService;
import com.example.group6project.service.PersonService;
import com.example.group6project.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/userViewController")
    public String displayAllAvailableTopics(Model model){
        List<Topic> topicList= topicService.displayAllTopicsAvailable(TopicStatus.NOT_DELETED);
        model.addAttribute("topicList",topicList);
        String keyword="";
        model.addAttribute("keyword",keyword);
        return "UserHomePage";
    }

    @GetMapping(value = "/viewCommentsController/{id}")
    public String viewAllComments(Model model, HttpSession session, @PathVariable(name = "id")Long id){
        Person user= (Person) session.getAttribute("User");
        System.out.println(user);
        List<Comments>commentsList=commentService.displayAllCommentsOnATopic(id,session,model);
        model.addAttribute("User",user);
        model.addAttribute("comments",commentsList);
        model.addAttribute("Body",new Comments());
        return "userCommentsView";
    }

    @GetMapping(value = "/postNewComment")
    public String postNewComment(Model model, HttpSession session, @ModelAttribute("Body")Comments comments){
        Person user= (Person) session.getAttribute("User");
        System.out.println(user);
        commentService.createNewComment(session,user,comments.getCommentBody());
        if(user.getUserType().equals(UserType.User)){
            return "redirect:/userViewController";}
        else{
            return "redirect:/adminViewController";
        }

    }
}
