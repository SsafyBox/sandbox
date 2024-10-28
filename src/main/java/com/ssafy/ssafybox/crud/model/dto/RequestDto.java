package com.ssafy.ssafybox.crud.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestDto {

    private String content;

    public RequestDto() {}

    public RequestDto(String content) {
        this.content = content;
    }
}