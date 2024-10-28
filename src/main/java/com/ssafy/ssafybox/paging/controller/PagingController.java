package com.ssafy.ssafybox.paging.controller;

import com.ssafy.ssafybox.paging.model.dto.ArticleDto;
import com.ssafy.ssafybox.paging.model.dto.CursorResponseDto;
import com.ssafy.ssafybox.paging.model.dto.OffsetResponseDto;
import com.ssafy.ssafybox.paging.model.dto.RequestDto;
import com.ssafy.ssafybox.paging.model.service.PagingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class PagingController {

    private final PagingService pagingService;

    public PagingController(PagingService pagingService) {
        this.pagingService = pagingService;
    }

    @GetMapping("/paging/offset")
    public OffsetResponseDto<ArticleDto> offset(@RequestParam int size, @RequestParam int page) {
        int offset = (page - 1) * size;
        return pagingService.getOffsetArticles(offset, size);
    }

    @GetMapping("/paging/cursor")
    public CursorResponseDto<ArticleDto> cursor(@RequestParam int size, @RequestParam int cursorId) {
        return pagingService.getCursorArticles(size, cursorId);
    }

    @PostMapping("/make")
    public void make(@RequestBody RequestDto requestDto) {
        pagingService.insertArticles(requestDto);
    }

}
