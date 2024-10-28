package com.ssafy.sandbox.paging.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder
public class ArticlesByCursorResponse {

    private Long lastId;
    private List<ArticleResponse> articles;
}
