package com.abdala.demo.entity;


import jakarta.persistence.*;
// import org.springframework.security.core.userdetails.User;
import com.abdala.demo.user.User;
import java.time.LocalDateTime;

@Entity
@Table(name = "article_favorite")
public class ArticleFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(name = "favorited_at", nullable = false)
    private LocalDateTime favoritedAt = LocalDateTime.now();

    // Getters and Setters
}