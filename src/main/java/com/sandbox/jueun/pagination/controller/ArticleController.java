package com.sandbox.jueun.pagination.controller;

import com.sandbox.jueun.pagination.dto.ArticleCursorListResponseDto;
import com.sandbox.jueun.pagination.dto.ArticleOffsetListResponseDto;
import com.sandbox.jueun.pagination.service.ArticleService;
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

        ArticleOffsetListResponseDto responseDto = articleService.getArticlesWithOffset(pageRequest);

       return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/paging/cursor")
    public ResponseEntity<?> getArticlesWithCursor(
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "0") Long cursorId)
    {
        log.info("size {}, cursorId {}", size, cursorId);

        PageRequest pageRequest = PageRequest.of(0, size);

        ArticleCursorListResponseDto responseDto = articleService.getArticlesWithCursor(pageRequest, cursorId);

        return ResponseEntity.ok().body(responseDto);
    }
}
