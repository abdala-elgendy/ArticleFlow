package com.abdala.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleCommentDTO {
    private Long articleId;
    private String content;
    private String author;
    private LocalDateTime createdAt;
}
