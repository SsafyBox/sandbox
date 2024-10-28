package com.ssafy.sandbox.paging.controller;

import com.ssafy.sandbox.paging.dto.request.RequestDto;
import com.ssafy.sandbox.paging.dto.response.CursorResponseDto;
import com.ssafy.sandbox.paging.dto.response.OffsetResponseDto;
import com.ssafy.sandbox.paging.service.PagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/articles")
@RequiredArgsConstructor
public class PagingController {
    private final PagingService pagingService;

    @GetMapping("/paging/offset")
    public OffsetResponseDto offsetPagination(@PageableDefault Pageable pageable) {
        return pagingService.offsetPagination(pageable);
    }
    @GetMapping("/paging/cursor")
    public CursorResponseDto cursorPagination(@PageableDefault Pageable pageable ,@RequestParam("cursorId") Long cursorId) {
        return pagingService.cursorPagination(pageable, cursorId);
    }

    @PostMapping("/make")
    public void addData(@RequestBody RequestDto requestDto) {
        pagingService.addData(requestDto);
    }
}
