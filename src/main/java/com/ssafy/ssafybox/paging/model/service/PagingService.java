package com.ssafy.ssafybox.paging.model.service;

import com.ssafy.ssafybox.paging.model.dto.ArticleDto;
import com.ssafy.ssafybox.paging.model.dto.CursorResponseDto;
import com.ssafy.ssafybox.paging.model.dto.OffsetResponseDto;
import com.ssafy.ssafybox.paging.model.dto.RequestDto;

public interface PagingService {

    OffsetResponseDto<ArticleDto> getOffsetArticles(int offset, int size);
    CursorResponseDto<ArticleDto> getCursorArticles(int size, int cursorId);
    void insertArticles(RequestDto requestDto);

}
