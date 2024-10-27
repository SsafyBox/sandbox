package com.ssafy.sandbox.paging.repository;

import com.ssafy.sandbox.paging.domain.Article;
import com.ssafy.sandbox.paging.dto.ArticleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Page<ArticleResponse> findPageBy(Pageable pageable);

}
