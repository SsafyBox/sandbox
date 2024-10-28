package com.ssafy.sandbox.paging.dto.response;

import com.ssafy.sandbox.paging.domain.ArticleEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CursorResponseDto {

    private Long lastId;
    private List<ArticleEntity> articles;

}
