package com.ssafy.ssafybox.paging.model.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
}
