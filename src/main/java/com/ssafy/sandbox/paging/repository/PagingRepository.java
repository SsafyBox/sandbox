package com.ssafy.sandbox.paging.repository;

import com.ssafy.sandbox.paging.domain.ArticleEntity;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagingRepository extends JpaRepository<ArticleEntity, Long> {
    Page<ArticleEntity> findAllByOrderByIdDesc(Pageable pageable);

    Page<ArticleEntity> findByIdLessThanOrderByIdDesc(Long id, Pageable pageable);

}
