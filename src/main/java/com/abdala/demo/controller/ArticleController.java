package com.abdala.demo.controller;

import com.abdala.demo.entity.Article;
import com.abdala.demo.service.ArticleService;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;
import com.abdala.demo.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleMapper articleMapper;


    @GetMapping("/tag/{tagName}")
    public List<ArticleDTO> getArticlesByTagName(@PathVariable String tagName) {
        return articleService.getArticlesByTagName(tagName);
    }


    @PostMapping
    public ArticleDTO createArticle(@RequestBody CreateArticleDTO createArticleDTO) {
        return articleService.createArticle(createArticleDTO);
    }


    @GetMapping("/{id}")
    public ArticleDTO getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody CreateArticleDTO updateArticleDTO) {
        ArticleDTO updatedArticle = articleService.updateArticle(id, updateArticleDTO);
        return ResponseEntity.ok(updatedArticle);
    }
}

// Delete an article by ID


