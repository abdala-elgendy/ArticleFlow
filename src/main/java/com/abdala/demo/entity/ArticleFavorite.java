//package com.abdala.demo.entity;
//
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class ArticleFavorite {
//
//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name="created_at")
//    private LocalDateTime createdAt;
//
//
//    @ManyToOne
//    @JoinColumn(name = "article_id")
//    private Article article;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public ArticleFavorite() {
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
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}

