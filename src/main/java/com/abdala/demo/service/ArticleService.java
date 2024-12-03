package com.abdala.demo.service;

import com.abdala.demo.entity.Article;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    ArticleDTO createArticle(CreateArticleDTO article);
    ArticleDTO updateArticle(int id, CreateArticleDTO article);
    void deleteArticle(int id);
    ArticleDTO getArticleById(int id);
    List<ArticleDTO> getAllArticles();
    List<ArticleDTO> getArticlesByAuthor(int authorId);

//    List<ArticleDTO> getArticlesByTagName(String tagName);
}
