package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.service.TodoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoIdResponse saveTodo(@RequestBody Todo todo) {
        Long id = todoService.save(todo);
        return new TodoIdResponse(id);
    }

    @GetMapping("/todos")
    public List<Todo> findAllTodo() {
        return todoService.findAll();
    }

    @PatchMapping("/todos/{id}")
    public TodoIdResponse saveTodo(@PathVariable Long id) {
        Long resId = todoService.update(id);
        return new TodoIdResponse(resId);
    }

    @Data
    static class TodoIdResponse {
        private Long id;

        public TodoIdResponse(Long id) {
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
