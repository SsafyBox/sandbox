package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.dto.request.CreateTodoRequest;
import com.ssafy.sandbox.dto.response.FindAllTodoResponse;
import com.ssafy.sandbox.dto.response.MessageResponse;
import com.ssafy.sandbox.dto.response.TodoIdResponse;
import com.ssafy.sandbox.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoIdResponse> saveTodo(@RequestBody CreateTodoRequest todoDto) {
        Todo todo = new Todo();
        todo.setContent(todoDto.getContent());

        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.save(todo));
    }

    @GetMapping("/todos")
    public ResponseEntity<FindAllTodoResponse> findAllTodo() {

        return ResponseEntity.ok(todoService.findAll());
    }

    @PatchMapping("/todos/{id}")
    public ResponseEntity<TodoIdResponse> updateTodo(@PathVariable Long id) {

        return ResponseEntity.ok(todoService.update(id));
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<MessageResponse> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);

        return ResponseEntity.ok(new MessageResponse("Deleted Successfully"));
    }

}