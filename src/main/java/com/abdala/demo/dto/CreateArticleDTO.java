package com.abdala.demo.dto;

import lombok.Data;

@Data
public class CreateArticleDTO {
    private String title;
    private String description;
    private String content;


    private String tagName;
}

