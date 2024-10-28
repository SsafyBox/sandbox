package com.ssafy.ssafybox.paging.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CursorResponseDto<T> {

    private Long lastId;
    private List<T> articles;

}
