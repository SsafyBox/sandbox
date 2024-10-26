package com.sandbox.jueun.pagination.controller;

import com.sandbox.jueun.pagination.dto.ArticleCursorListResponseDto;
import com.sandbox.jueun.pagination.dto.ArticleOffsetListResponseDto;
import com.sandbox.jueun.pagination.dto.ArticlePreviewDto;
import com.sandbox.jueun.pagination.servic.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/articles")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/paging/offset")
    public ResponseEntity<ArticleOffsetListResponseDto> getArticlesWithOffset(
            @RequestParam(defaultValue = "6") Integer size,
            @RequestParam(defaultValue = "1") Integer page
    ) {
        log.info("size {}, cursorId {}", size, page);
        Pageable pageRequest = PageRequest.of(page-1, size, Sort.by(Sort.Direction.DESC, "createdAt"));

        Page<ArticlePreviewDto> result = articleService.getArticlesWithOffset(pageRequest);

        ArticleOffsetListResponseDto responseDto= ArticleOffsetListResponseDto.from(result);

       return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/paging/cursor")
    public ResponseEntity<?> getArticlesWithCursor(
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "0") Long cursorId)
    {
        log.info("size {}, cursorId {}", size, cursorId);

        PageRequest pageRequest = PageRequest.of(0, size);

        Slice<ArticlePreviewDto> result = articleService.getArticlesWithCursor(pageRequest, cursorId);

        ArticleCursorListResponseDto responseDto = ArticleCursorListResponseDto.from(result);

        return ResponseEntity.ok().body(responseDto);
    }
}
