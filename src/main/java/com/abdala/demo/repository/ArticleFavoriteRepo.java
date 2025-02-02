package com.abdala.demo.repository;

import com.abdala.demo.entity.ArticleFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArticleFavoriteRepo extends JpaRepository<ArticleFavorite, Long> {

    List<ArticleFavorite> findByUserId(Long userId);
    boolean existsByUserIdAndArticleId(Long userId, Long articleId);
    void deleteByUserIdAndArticleId(Long userId, Long articleId);
}
