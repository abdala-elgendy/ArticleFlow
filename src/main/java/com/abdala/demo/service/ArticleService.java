package com.abdala.demo.service;

import com.abdala.demo.entity.Article;

import java.util.List;

public interface ArticleService {
    Article createArticle(Article article);
    Article updateArticle(Long id, Article article);
    void deleteArticle(Long id);
    Article getArticleById(Long id);
    List<Article> getAllArticles();
    List<Article> getArticlesByAuthor(Long authorId);
}
