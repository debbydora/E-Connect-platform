package com.example.group6project.models;

import com.example.group6project.enums.UserType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class Person extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
