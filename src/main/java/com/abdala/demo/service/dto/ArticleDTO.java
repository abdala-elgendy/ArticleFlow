package com.abdala.demo.service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ArticleDTO {
    private int id;
    private String title;
    private String description;
    private String content;
    private String tagName;
    private LocalDateTime createdAt;

}

