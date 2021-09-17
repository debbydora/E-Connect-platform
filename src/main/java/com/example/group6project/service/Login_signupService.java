package com.example.group6project.service;

import com.example.group6project.models.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface Login_signupService {
    String register(Person person);
    //    public ModelAndView login(@ModelAttribute("Person") Person person, ModelAndView modelAndView);
    String loginUser(String email, String password, HttpSession session, Model model);

}
