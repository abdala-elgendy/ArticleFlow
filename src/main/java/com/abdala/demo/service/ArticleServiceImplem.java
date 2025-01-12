package com.abdala.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.entity.User;
import com.abdala.demo.repository.ArticleCommentRepo;
import com.abdala.demo.repository.ArticleRepo;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;
import com.abdala.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abdala.demo.service.mapper.ArticleMapper;

@Service
public class ArticleServiceImplem implements ArticleService {

    @Autowired
    private ArticleRepo articleRepository;


    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleCommentRepo articleCommentRepo;


    @Override
    public ArticleDTO createArticle(CreateArticleDTO createArticleDTO) {
        Article article = articleMapper.toEntity(createArticleDTO);
        Article savedArticle = articleRepository.save(article);
        return articleMapper.toDTO(savedArticle);
    }

    @Override
    public ArticleDTO updateArticle(Long id, CreateArticleDTO updateArticleDTO) {
        return articleRepository.findById(id).map(existingArticle -> {
            existingArticle.setTitle(updateArticleDTO.getTitle());
            existingArticle.setDescription(updateArticleDTO.getDescription());
            existingArticle.setContent(updateArticleDTO.getContent());
            Article updatedArticle = articleRepository.save(existingArticle);
            return articleMapper.toDTO(updatedArticle);
        }).orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleDTO getArticleById(Long id) {
        return articleRepository.findById(id)
                .map(articleMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> getArticlesofAuthor(Long id) {
        // return articleRepository.findByAuthorId(authorId);

        return articleRepository.findByAuthorId(id)
                .stream()
                .map(articleMapper::toDTO)
              .collect(Collectors.toList());
    }

    @Override
    public List<ArticleComment> getArticleComments(Long articleId) {
        List<ArticleComment> articleComments = articleCommentRepo
                .findCommentsByArticleId
                (articleId);
        return articleComments;
    }

    @Override
    public User getAuthorOfArticle(Long articleId) {
        return articleRepository.getAuthorOfArticle(articleId);
    }

    @Override
    public List<ArticleDTO> getArticlesByTagName(String tagName) {
        return articleRepository.findArticlesByTagName(tagName)
                .stream()
                .map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleComment getComment( Long commentId) {
        return articleCommentRepo.findSpecificComment(commentId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Comment not found"));


    }


}


