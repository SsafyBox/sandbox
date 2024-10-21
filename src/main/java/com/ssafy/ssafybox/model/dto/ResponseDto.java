package com.ssafy.ssafybox.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
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

    @Override
    public String toString() {
        return "ResponseDto{" +
                "message='" + message + '\'' +
                '}';
    }
}