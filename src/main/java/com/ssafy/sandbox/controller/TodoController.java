package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.service.TodoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public CreateTodoResponse saveTodo(@RequestBody Todo todo) {
        Long id = todoService.save(todo);
        return new CreateTodoResponse(id);
    }

    @Data
    static class CreateTodoResponse {
        private Long id;

        public CreateTodoResponse(Long id) {
            this.id = id;
        }
    }
}
