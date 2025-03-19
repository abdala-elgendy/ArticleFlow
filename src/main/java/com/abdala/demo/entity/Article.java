package com.abdala.demo.entity;

import com.abdala.demo.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "article")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "tag_name")
    private String tagName;
    
    @Column(name = "slug")
    private String slug;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity = ArticleComment.class, cascade = CascadeType.ALL)
    private Set<ArticleComment> articleComments;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "author_id")
    private User author;

    // Custom builder method for creating a new article with default creation time
    public static ArticleBuilder builder() {
        return new ArticleBuilder()
                .createdAt(LocalDateTime.now());
    }

    public Article(String name, String s1, String content, String description, User user) {
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
