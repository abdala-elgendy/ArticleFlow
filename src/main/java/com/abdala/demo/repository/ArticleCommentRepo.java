package com.abdala.demo.repository;



import com.abdala.demo.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCommentRepo extends JpaRepository<ArticleComment, Long> {
  @Query("select ac from ArticleComment ac where ac.article.id = :articleId")
    List<ArticleComment> findCommentsByArticleId(Long articleId);

    void deleteAll();
}
