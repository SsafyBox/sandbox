package com.ssafy.ssafybox.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestDto {

    private String content;

    public RequestDto() {}

    public RequestDto(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "content='" + content + '\'' +
                '}';
    }
}