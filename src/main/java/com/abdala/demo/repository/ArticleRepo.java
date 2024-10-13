package com.abdala.demo.repository;

import com.abdala.demo.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a JOIN a.tags t WHERE t.name = :tagName")
    List<Article> findArticlesByTagName(@Param("tagName") String tagName);

    List<Article> findByAuthorId(Long authorId);
}
