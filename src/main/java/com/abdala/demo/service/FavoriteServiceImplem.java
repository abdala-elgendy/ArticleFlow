package com.abdala.demo.service;

import com.abdala.demo.dto.ArticleDTO;
import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.mapper.ArticleMapper;
import com.abdala.demo.repository.ArticleFavoriteRepo;
import com.abdala.demo.repository.ArticleRepo;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImplem implements FavoriteService {

    @Autowired
    private ArticleFavoriteRepo favoriteRepository;

    @Autowired
    private ArticleRepo articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserRepo userRepository;

    @Override
    public void addFavorite(Long userId, Long articleId) {
        // Check if favorite already exists
        if (favoriteRepository.existsByUserIdAndArticleId(userId, articleId)) {
            return; // Already favorited
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        ArticleFavorite favorite = new ArticleFavorite();
        favorite.setUser(user);
        favorite.setArticle(article);
        favoriteRepository.save(favorite);
    }

    @Override
    public void removeFavorite(Long userId, Long articleId) {
        favoriteRepository.deleteByUserIdAndArticleId(userId, articleId);
    }

    @Override
    public List<ArticleDTO> getFavoritesByUser(Long userId) {
        List<ArticleFavorite> favorites = favoriteRepository.findByUserId(userId);
        return favorites.stream()
                .map(fav -> articleMapper.toDTO(fav.getArticle()))
                .collect(Collectors.toList());
    }
}

