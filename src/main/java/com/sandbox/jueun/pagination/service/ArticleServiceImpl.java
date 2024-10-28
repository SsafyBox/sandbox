package com.sandbox.jueun.pagination.service;

import com.sandbox.jueun.pagination.dto.ArticleCursorListResponseDto;
import com.sandbox.jueun.pagination.dto.ArticleOffsetListResponseDto;
import com.sandbox.jueun.pagination.dto.ArticlePreviewDto;
import com.sandbox.jueun.pagination.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    @Override
    public ArticleOffsetListResponseDto getArticlesWithOffset(Pageable pageable) {
        Page<ArticlePreviewDto> result = articleRepository.findPageBy(pageable);

        return ArticleOffsetListResponseDto.from(result);
    }

    @Transactional(readOnly = true)
    @Override
    public ArticleCursorListResponseDto getArticlesWithCursor(Pageable pageable, Long cursorId) {

        Slice<ArticlePreviewDto> result = articleRepository.findSliceByIdGreaterThan(pageable, cursorId);

        return ArticleCursorListResponseDto.from(result);
    }
}
