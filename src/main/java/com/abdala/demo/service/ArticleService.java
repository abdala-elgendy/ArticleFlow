package com.abdala.demo.service;

import com.abdala.demo.entity.Article;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO createArticle(CreateArticleDTO article);
    ArticleDTO updateArticle(Long id, CreateArticleDTO article);
    void deleteArticle(Long id);
    ArticleDTO getArticleById(Long id);
    List<ArticleDTO> getAllArticles();
    List<ArticleDTO> getArticlesByAuthor(Long authorId);

    List<ArticleDTO> getArticlesByTagName(String tagName);
}
