package com.abdala.demo.service;

import java.util.List;

import com.abdala.demo.entity.Article;
import com.abdala.demo.repository.ArticleRepo;
import com.abdala.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleServiceImplem implements ArticleService {

    @Autowired
    private ArticleRepo articleRepository;

    @Autowired
    private UserRepo userRepository;

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        return articleRepository.findById(id).map(existingArticle -> {
            existingArticle.setContent(article.getContent());
            existingArticle.setDescription(article.getDescription());

            existingArticle.setTitle(article.getTitle());
            return articleRepository.save(existingArticle);
        }).orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getArticlesByAuthor(Long authorId) {
        return articleRepository.findByAuthorId(authorId);
    }
}


