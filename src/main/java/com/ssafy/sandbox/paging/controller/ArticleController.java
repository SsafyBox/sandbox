package com.ssafy.sandbox.paging.controller;

import com.ssafy.sandbox.paging.domain.Article;
import com.ssafy.sandbox.paging.dto.ArticleResponse;
import com.ssafy.sandbox.paging.dto.ArticlesByCursorResponse;
import com.ssafy.sandbox.paging.dto.ArticlesByOffsetResponse;
import com.ssafy.sandbox.paging.service.ArticleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles/paging")
public class ArticleController {

    private final ArticleService articleService;
    private static final String DEFAULT_PAGE_NO = "1";
    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_CURSOR_ID = "0";

    @GetMapping("/offset")
    public ResponseEntity<ArticlesByOffsetResponse> findArticleByOffset(
            @RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ArticleResponse> list = articleService.findArticleByOffset(pageable);

        ArticlesByOffsetResponse articles = ArticlesByOffsetResponse.builder()
                .currentPageNumber(list.getNumber())
                .size(list.getSize())
                .totalPage(list.getTotalPages())
                .hasNext(list.hasNext())
                .hasPrevious(list.hasPrevious())
                .articles(list.getContent())
                .build();

        return ResponseEntity.ok(articles);
    }

    @GetMapping("/cursor")
    public ResponseEntity<ArticlesByCursorResponse> findArticleByCursor(
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(defaultValue = DEFAULT_CURSOR_ID) Long cursorId) {
        Pageable pageable = PageRequest.of(0, size);
        List<ArticleResponse> articles = articleService.findArticleByCursor(cursorId, pageable);
        Long lastId = !articles.isEmpty() ? articles.get(articles.size() - 1).getId() : cursorId;

        ArticlesByCursorResponse articlesResponse = ArticlesByCursorResponse.builder()
                .lastId(lastId)
                .articles(articles)
                .build();

        return ResponseEntity.ok(articlesResponse);
    }

}
