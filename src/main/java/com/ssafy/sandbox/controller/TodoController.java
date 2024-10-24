package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.request.CreateRequestDto;
import com.ssafy.sandbox.dto.response.CreateResponseDto;
import com.ssafy.sandbox.dto.response.ReadResponseDto;
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
    public CreateResponseDto createTodo(@RequestBody CreateRequestDto createRequestDto) {
        return todoService.create(createRequestDto);
    }

    @GetMapping("/todos")
    public ReadResponseDto readTodos() {
        ReadResponseDto readResponseDto = new ReadResponseDto();
        readResponseDto.setTodos(todoService.read());
        return readResponseDto;
    }

    @PatchMapping("/todos/{todoId}")
    public ResponseEntity<Void> updateCompleted(@PathVariable("todoId") Long id) {
        todoService.update(id);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("todoId") Long id) {
        todoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
