package com.abdala.demo.controller;

import com.abdala.demo.dto.ArticleCommentDTO;
import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.user.Role;
import com.abdala.demo.user.User;
import com.abdala.demo.repository.ArticleRepo;
import com.abdala.demo.service.ArticleService;
import com.abdala.demo.dto.ArticleDTO;
import com.abdala.demo.dto.CreateArticleDTO;
import com.abdala.demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleRepo articleRepo;


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

        try {
         articleService.getArticleById(id);
        }catch (Exception e){
            throw new RuntimeException("Article not found");
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
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deleteArticle(@PathVariable Long id) {
       try {
           articleService.getArticleById(id);
       }catch (Exception e){
           return "article dosn't exist";
       }
        articleService.deleteArticle(id);
        return "article deleted";

    }

    @GetMapping("/{id}/comments") // solve bug in this request latter
    public ResponseEntity<List<ArticleCommentDTO>> getArticleComments(@PathVariable Long id) {
List<ArticleCommentDTO> result= articleService.getArticleComments(id);
        return ResponseEntity.ok(result);
    }

    //ok
    @GetMapping("/slug/{slug}")
    public ArticleDTO getByArticleSlug(@PathVariable String slug) {
        Article article = articleRepo.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Article not found with slug: " + slug));
        return articleMapper.toDTO(article);
    }

    @GetMapping("/{id}/author")
    public ResponseEntity<User> authorOfArticle(@PathVariable Long articleId) {
        return ResponseEntity.ok(articleService.getAuthorOfArticle(articleId));
    }
    @GetMapping ("/comment/{commentId}")
    public ResponseEntity<ArticleCommentDTO> getComment( @PathVariable Long commentId){

        return ResponseEntity.ok(articleService.getComment(commentId));
    }
}




