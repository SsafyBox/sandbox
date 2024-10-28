package com.ssafy.sandbox.paging.dto.request;

import com.ssafy.sandbox.paging.domain.ArticleEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class RequestDto {
    private List<ArticleEntity> articles;
}
