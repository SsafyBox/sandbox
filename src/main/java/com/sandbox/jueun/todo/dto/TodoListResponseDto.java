package com.sandbox.jueun.todo.dto;

import com.sandbox.jueun.todo.domain.Todo;
import lombok.Data;

import java.util.List;

@Data
public class TodoListResponseDto {

    public TodoListResponseDto(List<Todo> list, String message) {
        this.todos = list;
        this.message = message;
    }

    private List<Todo> todos;

    private String message;
}
