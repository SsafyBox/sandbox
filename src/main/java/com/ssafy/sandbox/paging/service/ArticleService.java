package com.ssafy.sandbox.paging.service;

import com.ssafy.sandbox.paging.domain.Article;
import com.ssafy.sandbox.paging.dto.ArticleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    Page<ArticleResponse> findArticleByOffset(Pageable pageable);
    List<ArticleResponse> findArticleByCursor(Long cursorId, Pageable pageable);

}
