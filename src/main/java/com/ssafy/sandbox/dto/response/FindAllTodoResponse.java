package com.ssafy.sandbox.dto.response;

import com.ssafy.sandbox.domain.Todo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class FindAllTodoResponse {
    private List<Todo> todos;

    @Builder
    public FindAllTodoResponse(List<Todo> todos) {
        this.todos = todos;
    }
}
