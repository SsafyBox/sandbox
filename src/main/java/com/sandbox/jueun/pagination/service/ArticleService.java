package com.sandbox.jueun.pagination.service;

import com.sandbox.jueun.pagination.dto.ArticleCursorListResponseDto;
import com.sandbox.jueun.pagination.dto.ArticleOffsetListResponseDto;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    public ArticleOffsetListResponseDto getArticlesWithOffset(Pageable pageable);

    public ArticleCursorListResponseDto getArticlesWithCursor(Pageable pageable, Long cursorId);
}
