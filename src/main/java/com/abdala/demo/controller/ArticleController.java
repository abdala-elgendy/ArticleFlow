package com.abdala.demo.controller;

import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.entity.User;
import com.abdala.demo.service.ArticleService;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;
import com.abdala.demo.service.mapper.ArticleMapper;
import com.abdala.demo.service.mapper.UserMapper;
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


//    @GetMapping("/tag/{tagName}")
//    public List<ArticleDTO> getArticlesByTagName(@PathVariable String tagName) {
//        return articleService.getArticlesByTagName(tagName);
//    }


    @PostMapping
    public ArticleDTO createArticle(@RequestBody CreateArticleDTO createArticleDTO) {
        return articleService.createArticle(createArticleDTO);
    }


    @GetMapping("/{id}")
    public ArticleDTO getArticleById(@PathVariable Long id) {

        try {
         articleService.getArticleById(id);
        }catch (Exception e){
           return new ArticleDTO();
        }
        ArticleDTO article=   articleService.getArticleById(id);
        return article ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody CreateArticleDTO updateArticleDTO) {
        ArticleDTO updatedArticle = articleService.updateArticle(id, updateArticleDTO);
        return ResponseEntity.ok(updatedArticle);
    }
    @DeleteMapping("/{id}")
    public String updateArticle(@PathVariable Long id) {
       try {
           articleService.getArticleById(id);
       }catch (Exception e){
           return "article dosn't exist";
       }
        articleService.deleteArticle(id);
        return "article deleted";

    }
    @GetMapping("/{id}/comments")
    public ResponseEntity<List<ArticleComment>> getArticleComments(@PathVariable Long id) {
List<ArticleComment> res= articleService.getArticleComments(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}/author")
    public ResponseEntity<User> authorOfArticle(@PathVariable Long articleId) {
        return ResponseEntity.ok(articleService.getAuthorOfArticle(articleId));
    }
}

// Delete an article by ID


