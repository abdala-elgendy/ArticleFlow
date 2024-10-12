package com.abdala.demo.repository;


import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.Tag;
import com.abdala.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag,Long> {

    @Query(value="select  )
    List<Article>  findArticlesByName(String name);
}

