package com.ssafy.sandbox.paging.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Builder
public class ArticlesByOffsetResponse {

    private Integer currentPageNumber;
    private Integer size;
    private Integer totalPage;
    private Boolean hasNext;
    private Boolean hasPrevious;
    private List<ArticleResponse> articles;

}
