package com.sandbox.jueun.pagination.dto;

import lombok.Getter;
import org.springframework.data.domain.Slice;

import java.util.List;

@Getter
public class ArticleCursorListResponseDto {
    long lastId;
    int size;
    boolean hasNext;
    List<ArticlePreviewDto> articles;

    public static ArticleCursorListResponseDto from(Slice<ArticlePreviewDto> result) {
        ArticleCursorListResponseDto responseDto = new ArticleCursorListResponseDto();
        responseDto.articles = result.getContent();
        responseDto.hasNext = result.hasNext();
        responseDto.size = result.getSize();
        responseDto.lastId = responseDto.articles.get(responseDto.articles.size()-1).id();
        return responseDto;
    }
}
