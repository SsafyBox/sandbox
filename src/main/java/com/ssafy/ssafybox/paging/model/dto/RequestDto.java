package com.ssafy.ssafybox.paging.model.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestDto {
    private List<ArticleDto> articles; // ArticleDto 객체 리스트
}
