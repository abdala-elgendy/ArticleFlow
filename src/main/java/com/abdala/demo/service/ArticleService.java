package com.abdala.demo.service;

import com.abdala.demo.dto.ArticleCommentDTO;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.user.User;
import com.abdala.demo.dto.ArticleDTO;
import com.abdala.demo.dto.CreateArticleDTO;
import org.springframework.stereotype.Service;
import com.abdala.demo.entity.Article;
import com.abdala.demo.factory.ArticleFactory;
import com.abdala.demo.factory.CommentFactory;
import com.abdala.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    ArticleCommentDTO getComment(Long commentId);

    List<ArticleDTO> findByContentContainingIgnoreCase(String keyword);

    ArticleCommentDTO createComment(Long articleId, ArticleCommentDTO articleCommentDTO);

    Article createArticle(String title, String content, String description, User author, String tagName);

    ArticleComment addCommentToArticle(String content, Article article, User user);

    Article createArticleWithComment(String title, String content, String description, 
                                  User author, String tagName, String commentContent, User commenter);
}
