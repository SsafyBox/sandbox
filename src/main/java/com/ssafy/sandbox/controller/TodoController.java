package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.service.TodoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public CreateTodoResponse saveTodo(@RequestBody Todo todo) {
        Long id = todoService.save(todo);
        return new CreateTodoResponse(id);
    }

    @GetMapping("/todos")
    public List<Todo> findAllTodo() {
        return todoService.findAll();
    }

    @Data
    static class CreateTodoResponse {
        private Long id;

        public CreateTodoResponse(Long id) {
            this.id = id;
        }
    }

//    @Data
//    static class FindTodoResponse {
//        private Long id;
//        private String content;
//
//        public FindTodoResponse(Long id, String content) {
//            this.id = id;
//            this.content = content;
//        }
//    }
}
