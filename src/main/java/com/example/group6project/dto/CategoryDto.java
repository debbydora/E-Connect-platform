package com.example.group6project.dto;

import com.example.group6project.enums.TopicCategory;
import lombok.Data;

@Data
public class CategoryDto {
    private TopicCategory topicCategory;
    private String topicTitle;
}
