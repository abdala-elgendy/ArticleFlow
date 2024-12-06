package com.abdala.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.abdala.demo.entity.Article;
import com.abdala.demo.repository.ArticleRepo;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abdala.demo.service.mapper.ArticleMapper;

@Service
public class ArticleServiceImplem implements ArticleService {

    @Autowired
    private ArticleRepo articleRepository;



    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleDTO createArticle(CreateArticleDTO createArticleDTO) {
        Article article = articleMapper.toEntity(createArticleDTO);
        Article savedArticle = articleRepository.save(article);
        return articleMapper.toDTO(savedArticle);
    }

    @Override
    public ArticleDTO updateArticle(int id, CreateArticleDTO updateArticleDTO) {
        return articleRepository.findById(id).map(existingArticle -> {
            existingArticle.setTitle(updateArticleDTO.getTitle());
            existingArticle.setDescription(updateArticleDTO.getDescription());
            existingArticle.setContent(updateArticleDTO.getContent());
            Article updatedArticle = articleRepository.save(existingArticle);
            return articleMapper.toDTO(updatedArticle);
        }).orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleDTO getArticleById(int id) {
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
    public List<ArticleDTO> getArticlesByAuthor(int id) {
       // return articleRepository.findByAuthorId(authorId);

        return articleRepository.findById(id)
                .map(articleMapper::toDTO)
                .stream().collect(Collectors.toList());
    }

//    @Override
//    public List<ArticleDTO> getArticlesByTagName(String tagName) {
//        List<Article> articles = articleRepository.findArticlesByTagName(tagName);
//        return articles.stream()
//                .map(articleMapper::toDTO)
//                .collect(Collectors.toList());
//    }
}


