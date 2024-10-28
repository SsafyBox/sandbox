package com.ssafy.sandbox.paging.dto.response;

import com.ssafy.sandbox.paging.domain.ArticleEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OffsetResponseDto {

    private int totalPage;
    private List<ArticleEntity> articles;

}
