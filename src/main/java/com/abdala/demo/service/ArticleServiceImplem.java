package com.abdala.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.abdala.demo.dto.ArticleCommentDTO;
import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.mapper.CommentMapper;
import com.abdala.demo.user.User;
import com.abdala.demo.repository.ArticleCommentRepo;
import com.abdala.demo.repository.ArticleRepo;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.dto.ArticleDTO;
import com.abdala.demo.dto.CreateArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.abdala.demo.mapper.ArticleMapper;

@Service
public class ArticleServiceImplem implements ArticleService {

    @Autowired
    private ArticleRepo articleRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleCommentRepo articleCommentRepo;
    @Autowired
    private UserRepo userRepo;

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
    @CacheEvict(value = "articles")
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleDTO getArticleById(Long id) {
        return articleRepository.findById(id).map(articleMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    @Cacheable(value = "articles")
    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(articleMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> getArticlesofAuthor(Long id) {
        // return articleRepository.findByAuthorId(authorId);

        return articleRepository.findArticleByAuthorId(id).stream().map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleCommentDTO> getArticleComments(Long articleId) {
        List<ArticleComment> articleComments = articleCommentRepo.findCommentsByArticleId(articleId);
        return articleComments.stream().map(articleMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public User getAuthorOfArticle(Long articleId) {

        return userRepo.findUserByArticleId(articleId);
    }

    @Override
    public List<ArticleDTO> getArticlesByTagName(String tagName) {
        return articleRepository.findArticlesByTagName(tagName).stream().map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleCommentDTO getComment(Long commentId) {
        ArticleComment ac = articleCommentRepo.findSpecificComment(commentId);

        return articleMapper.toDTO(ac);

    }

    @Override
    public List<ArticleDTO> findByContentContainingIgnoreCase(String keyword) {
        List<Article> articles = articleRepository.findByContentContainingIgnoreCase(keyword);

        return articles.stream().map(articleMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ArticleCommentDTO createComment(Long articleId, ArticleCommentDTO articleCommentDTO) {
        ArticleComment articleComment = commentMapper.toEntity(articleCommentDTO);
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        articleComment.setArticle(article);
        ArticleComment savedComment = articleCommentRepo.save(articleComment);
        return articleMapper.toDTO(savedComment);
    }

}