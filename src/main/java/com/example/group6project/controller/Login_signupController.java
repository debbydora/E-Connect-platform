package com.example.group6project.controller;

import com.example.group6project.models.Person;
import com.example.group6project.repository.PersonRepository;
import com.example.group6project.service.impl.Login_signupServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class Login_signupController {
    @Autowired
    private final Login_signupServiceImpl login_signupService;

    private final PersonRepository personRepository;

    @GetMapping("/")
    public String homePage (Model model){
        model.addAttribute("User",new Person());
        return "Login";
    }

    //    @GetMapping("/login")
//    public String login ( ){
//        return "Login";
//    }
//    @PostMapping("/login")
//    public ModelAndView login(@ModelAttribute("User") Person person, ModelAndView modelAndView){
//        login_signupService.login(person, modelAndView);
//        return modelAndView;
//    }
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("User")Person person, Model model, HttpSession session){
        return login_signupService.loginUser(person.getEmail(),person.getPassword(),session,model);
    }

    @GetMapping("/regMap")
    public String registration ( ){
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String register (@ModelAttribute("Person") Person person, Model model){
        login_signupService.register(person);
        return "Login";
    }

    @GetMapping(value = "/logOut")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
