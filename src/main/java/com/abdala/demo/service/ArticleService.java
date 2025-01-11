package com.abdala.demo.service;

import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.entity.User;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;
import com.abdala.demo.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    ArticleDTO createArticle(CreateArticleDTO article);
    ArticleDTO updateArticle(Long id, CreateArticleDTO article);
    void deleteArticle(Long id);
    ArticleDTO getArticleById(Long id);
    List<ArticleDTO> getAllArticles();
    List<ArticleDTO> getArticlesofAuthor(Long authorId);
    List<ArticleComment> getArticleComments(Long articleId);

    User getAuthorOfArticle(Long articleId);

    List<ArticleDTO> getArticlesByTagName(String tagName);

    ArticleComment getComment( Long commentId);

//    List<ArticleDTO> getArticlesByTagName(String tagName);
}
