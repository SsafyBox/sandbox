package com.ssafy.ssafybox.paging.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OffsetResponseDto<T> {

    private int totalPage;
    private List<T> articles;

}
