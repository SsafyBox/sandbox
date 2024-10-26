package com.sandbox.jueun.pagination.servic;

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
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticlePreviewDto> getArticlesWithOffset(Pageable pageable) {
        return articleRepository.findPageBy(pageable);
    }

    @Transactional(readOnly = true)
    public Slice<ArticlePreviewDto> getArticlesWithCursor(Pageable pageable, Long cursorId) {
        return articleRepository.findSliceByIdGreaterThan(pageable, cursorId);
    }
}
