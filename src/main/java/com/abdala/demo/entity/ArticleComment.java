//package com.abdala.demo.entity;
//
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class ArticleComment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String content;
//    private LocalDateTime createdAt;
//
//    @ManyToOne
//    @JoinColumn(name = "article_id")
//    private Article article;
//
//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private User author;
//
//    public ArticleComment() {
//        this.createdAt = LocalDateTime.now();
//    }
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Article getArticle() {
//        return article;
//    }
//
//    public void setArticle(Article article) {
//        this.article = article;
//    }
//
//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
//}
//
