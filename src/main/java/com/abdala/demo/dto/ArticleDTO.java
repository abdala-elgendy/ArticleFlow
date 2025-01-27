package com.abdala.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
    private String tagName;
    private String slug;
    private LocalDateTime createdAt;

}

