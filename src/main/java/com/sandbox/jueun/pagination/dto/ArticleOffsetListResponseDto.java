package com.sandbox.jueun.pagination.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class ArticleOffsetListResponseDto {
    int currentPageNumber;
    int totalPage;
    boolean hasNext;
    boolean hasPrevious;
    List<ArticlePreviewDto> articles;

    private ArticleOffsetListResponseDto() {}

    public static ArticleOffsetListResponseDto from(Page<ArticlePreviewDto> result) {
        ArticleOffsetListResponseDto responseDto = new ArticleOffsetListResponseDto();
        responseDto.currentPageNumber = result.getNumber()+1;
        responseDto.totalPage = result.getTotalPages();
        responseDto.hasNext = result.hasNext();
        responseDto.hasPrevious = result.hasPrevious();
        responseDto.articles = result.getContent();

        return responseDto;
    }
}
