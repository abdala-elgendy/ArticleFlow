package com.abdala.demo.service.dto;

import lombok.Data;

@Data
public class CreateArticleDTO {
    private String title;
    private String description;
    private String content;
    private String slug; // You can generate slug dynamically in the service layer
}

