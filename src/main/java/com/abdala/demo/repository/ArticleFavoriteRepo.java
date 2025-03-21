package com.abdala.demo.repository;

import com.abdala.demo.entity.ArticleFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticleFavoriteRepo extends JpaRepository<ArticleFavorite, Long> {

    List<ArticleFavorite> findByUserId(Long userId);

    boolean existsByUserIdAndArticleId(Long userId, Long articleId);

    @Modifying
    @Transactional
    void deleteByUserIdAndArticleId(Long userId, Long articleId);
}
