package com.abdala.demo.repository;



import com.abdala.demo.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCommentRepo extends JpaRepository<ArticleComment, Long> {

    void deleteAll();
}
