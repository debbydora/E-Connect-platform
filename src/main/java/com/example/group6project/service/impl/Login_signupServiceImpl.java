package com.example.group6project.service.impl;

import com.example.group6project.enums.UserType;
import com.example.group6project.models.Person;
import com.example.group6project.repository.PersonRepository;
import com.example.group6project.service.Login_signupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Login_signupServiceImpl implements Login_signupService {
    @Autowired
    private final PersonRepository personRepository;

    @Override
    public String register(Person person) {
        person.setUserType(UserType.User);
        personRepository.save(person);
        return "user has been added to the database";
    }

    @Override
    public String loginUser(String email, String password, HttpSession session, Model model) {
        Person person = personRepository.getPersonByEmailAndPassword(email,password);
        String view="";
        if(person!=null){

            if(person.getUserType().equals(UserType.ADMIN)){
                session.setAttribute("User",person);
                view= "redirect:/adminViewController" ;
            }
            else if(person.getUserType().equals(UserType.User)){
                session.setAttribute("User",person);
                view= "redirect:/userViewController";
            }
        }
        else{
            model.addAttribute("message","invalid email or password");
            model.addAttribute("error","Don't have an account, Signup here!");
            view="Login";
        }
        return view;
    }


//    @Override
//    public ModelAndView login(Person person, ModelAndView modelAndView) {
//        Optional<Person> userExist = personRepository.findByUsername(person.getUsername());
//        System.out.println("USER#### " + userExist);
//        if (userExist.isPresent() && person.getPassword().equals(userExist.get().getPassword())) {
//            if (userExist.get().getUserType().equalsIgnoreCase("admin")){
//                modelAndView.setViewName("redirect:/adminViewController");
//            }
//            else{
//                modelAndView.setViewName("UserHomePage");
//            }
//        }
//        else    {
//            modelAndView.setViewName("registrationPage");
//            modelAndView.addObject("error", "Please signup to proceed");
//        }
//        return modelAndView;
//    }



}
