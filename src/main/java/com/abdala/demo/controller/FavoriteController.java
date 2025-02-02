package com.abdala.demo.controller;

import com.abdala.demo.dto.ArticleDTO;
import com.abdala.demo.service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/{userId}/{articleId}")
    public ResponseEntity<Void> addFavorite(@PathVariable Long userId, @PathVariable Long articleId) {
        favoriteService.addFavorite(userId, articleId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{articleId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long userId, @PathVariable Long articleId) {
        favoriteService.removeFavorite(userId, articleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ArticleDTO>> getFavorites(@PathVariable Long userId) {
        List<ArticleDTO> favorites = favoriteService.getFavoritesByUser(userId);
        return ResponseEntity.ok(favorites);
    }
}
