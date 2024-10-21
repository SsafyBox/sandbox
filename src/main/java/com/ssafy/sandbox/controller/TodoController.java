package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.service.TodoService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @ResponseStatus(HttpStatus.CREATED)
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
    public TodoIdResponse updateTodo(@PathVariable Long id) {
        Long resId = todoService.update(id);
        return new TodoIdResponse(resId);
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return "Deleted Successfully";
    }

    @Data
    static class TodoIdResponse {
        private Long id;

        public TodoIdResponse(Long id) {
            this.id = id;
        }
    }
}