package com.abdala.demo.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "article")
@Getter
@Setter


public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name="content")
    private String content;

    @Column(name="description")
    private String description;

    @Column(name="title")
    private String title;


    @Column(name="created_at")
    private LocalDateTime createdAt;

   @Column (name="tag_name")
   private String tagName;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ArticleComment.class, cascade = CascadeType.ALL)
   Set<ArticleComment> articleComments;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @ManyToOne
    @NotNull
    @JoinColumn(name = "author_id")
    private User author;

    public Article() {
        this.createdAt = LocalDateTime.now();

    }




    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

