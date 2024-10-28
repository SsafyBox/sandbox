package com.ssafy.sandbox.paging.service;

import com.ssafy.sandbox.paging.domain.Article;
import com.ssafy.sandbox.paging.dto.ArticleResponse;
import com.ssafy.sandbox.paging.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Page<ArticleResponse> findArticleByOffset(Pageable pageable) {
        return articleRepository.findPageBy(pageable);
    }

    @Override
    public List<ArticleResponse> findArticleByCursor(Long cursorId, Pageable pageable) {
        return articleRepository.findByIdGreaterThanOrderByIdAsc(cursorId, pageable);
    }
}
