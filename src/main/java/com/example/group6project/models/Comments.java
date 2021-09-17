package com.example.group6project.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Comments extends BaseModel{
    private String commentBody;
    @DateTimeFormat(pattern = "yyyy:mm:dd")
    private LocalDate localDate;
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime localTime;
    private LocalDateTime localDateTime;
    @ManyToOne
    private Topic topic;
    @ManyToOne
    private Person person;
}
