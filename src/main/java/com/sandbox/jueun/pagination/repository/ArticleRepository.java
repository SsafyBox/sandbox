package com.sandbox.jueun.pagination.repository;

import com.sandbox.jueun.pagination.domain.Article;
import com.sandbox.jueun.pagination.dto.ArticlePreviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    public Page<ArticlePreviewDto> findPageBy(Pageable pageable);

    public Slice<ArticlePreviewDto> findSliceByIdGreaterThan(Pageable pageable, Long id);
}