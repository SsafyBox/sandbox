package com.sandbox.jueun.todo.controller;

import com.sandbox.jueun.todo.domain.Todo;
import com.sandbox.jueun.todo.dto.TodoCreateRequestDto;
import com.sandbox.jueun.todo.dto.TodoListResponseDto;
import com.sandbox.jueun.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/todos")
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<TodoListResponseDto> getTodoList() {
        List<Todo> result = todoService.getTodoList();

        return ResponseEntity.ok().body(new TodoListResponseDto(result, "정상 영업합니다."));
    }

    @PostMapping
    public ResponseEntity<?> postTodo(@RequestBody TodoCreateRequestDto requestDto) {
        todoService.createTodo(requestDto.getContent());

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<?> updateCompleted(@PathVariable long todoId) {
        todoService.updateCompleted(todoId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable long todoId) {
        todoService.deleteTodo(todoId);

        return ResponseEntity.ok().build();
    }
}
