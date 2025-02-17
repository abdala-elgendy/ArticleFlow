package com.abdala.demo.service;

import com.abdala.demo.dto.ArticleCommentDTO;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.user.User;
import com.abdala.demo.dto.ArticleDTO;
import com.abdala.demo.dto.CreateArticleDTO;
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
    List<ArticleCommentDTO> getArticleComments(Long articleId);

    User getAuthorOfArticle(Long articleId);

    List<ArticleDTO> getArticlesByTagName(String tagName);

    ArticleCommentDTO getComment( Long commentId);

//    List<ArticleDTO> getArticlesByTagName(String tagName);
}
