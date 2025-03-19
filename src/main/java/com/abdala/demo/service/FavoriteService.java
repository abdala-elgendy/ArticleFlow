package com.abdala.demo.service;

import com.abdala.demo.dto.ArticleDTO;

import java.util.List;

public interface FavoriteService {
    void addFavorite(Long userId, Long articleId);

    void removeFavorite(Long userId, Long articleId);

    List<ArticleDTO> getFavoritesByUser(Long userId);
}
