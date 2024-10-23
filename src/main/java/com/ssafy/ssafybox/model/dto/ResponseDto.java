package com.ssafy.ssafybox.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class ResponseDto {

    private String message;
    private List<TodoDto> todos;

    public ResponseDto() {}

    public ResponseDto(String message) {
        this.message = message;
    }

    public ResponseDto(String message, List<TodoDto> todos) {
        this.message = message;
        this.todos = todos;
    }
}