package com.abdala.demo.repository;

import com.abdala.demo.entity.Article;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article, Long> {


    List<Article> findByAuthorId(Long authorId);
}
