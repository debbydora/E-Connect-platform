package com.example.group6project.models;

import com.example.group6project.enums.TopicCategory;
import com.example.group6project.enums.TopicStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Entity
@Data
@Table
public class Topic extends BaseModel{

    private String topicTitle;
    private LocalDate dateCreated;
    private LocalTime timeCreated;
    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private TopicStatus topicStatus;
    @Enumerated(EnumType.STRING)
    private TopicCategory topicCategory;


}
