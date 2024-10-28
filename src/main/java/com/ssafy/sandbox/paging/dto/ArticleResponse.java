package com.ssafy.sandbox.paging.dto;

import com.ssafy.sandbox.paging.domain.Article;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
public class ArticleResponse {

    private Long id;
    private String title;
    private LocalDateTime createdAt;

}
