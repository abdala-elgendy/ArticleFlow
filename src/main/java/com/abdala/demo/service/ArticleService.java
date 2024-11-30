package com.abdala.demo.service;

import com.abdala.demo.entity.Article;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO createArticle(CreateArticleDTO article);
    ArticleDTO updateArticle(Integer id, CreateArticleDTO article);
    void deleteArticle(Integer id);
    ArticleDTO getArticleById(Integer id);
    List<ArticleDTO> getAllArticles();
    List<ArticleDTO> getArticlesByAuthor(Integer authorId);

//    List<ArticleDTO> getArticlesByTagName(String tagName);
}
