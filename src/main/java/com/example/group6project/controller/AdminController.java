package com.example.group6project.controller;

import com.example.group6project.dto.CategoryDto;
import com.example.group6project.enums.TopicCategory;
import com.example.group6project.enums.TopicStatus;
import com.example.group6project.enums.UserType;
import com.example.group6project.models.Comments;
import com.example.group6project.models.Person;
import com.example.group6project.models.Topic;
import com.example.group6project.service.CommentService;
import com.example.group6project.service.TopicService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class  AdminController  {
    @Autowired
    private TopicService topicService;
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/adminViewController")  //replace with admin view controller servlet
    public String displayAllAvailableTopics(Model model,HttpSession session){
        List<Topic> topicList= topicService.displayAllTopicsAvailable(TopicStatus.NOT_DELETED);
        model.addAttribute("topicList",topicList);
        Person user= (Person) session.getAttribute("User");
        String keyword="";
        model.addAttribute("keyword",keyword);
        model.addAttribute("user");
        return "adminHomePage";
    }

    @GetMapping(value = "/addNewTopic")
    public String getNewTopicPage(Model model){
        model.addAttribute("category",new CategoryDto());
        List<TopicCategory>categories= List.of(TopicCategory.values());
        model.addAttribute("categories",categories);
        return "addTopic";
    }

    @GetMapping(value = "/deleteTopic/{id}")
    public String deleteATopic(Model model,@PathVariable(name = "id")Long id){
        topicService.deleteTopic(id);
        return "redirect:/adminViewController"; //replace with admin service controller
    }



    @PostMapping(value = "addNewTopic")
    public String addNewTopic(Model model, @ModelAttribute("category")CategoryDto categoryDto){
        topicService.createNewTopic(categoryDto);
        return "redirect:/adminViewController"; // replace with admin view page
    }

    @GetMapping(value = "/displayCommentsForAdmin/{id}")
    public  String loadCommentsPageForAdmin(Model model, @PathVariable(name = "id")Long id, HttpSession session){
        List<Comments>commentsList=commentService.displayAllCommentsOnATopic(id,session,model);
        //get user atttribute from session here
        model.addAttribute("comments",commentsList);
        return "adminCommentsView";
    }

    @PostMapping( value = "/searchBar")
    public String displaySearchResults(@RequestParam(name = "keyword")String keyword,Model model,HttpSession session){
        Person user= (Person) session.getAttribute("User");
        System.out.println(user);
        List<Topic>topicList=topicService.displayAllSearchedTopics(keyword);
        System.out.println(topicList);
        model.addAttribute("searchedTopics",topicList);
        model.addAttribute("keyword",keyword);
        if(user.getUserType().equals(UserType.ADMIN)){
            return "searchPage";
        }else{
            return "userSearchPage";
        }

    }



}
