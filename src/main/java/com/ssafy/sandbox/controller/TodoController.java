package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.dto.request.CreateTodoRequest;
import com.ssafy.sandbox.dto.response.FindAllTodoResponse;
import com.ssafy.sandbox.dto.response.TodoIdResponse;
import com.ssafy.sandbox.service.TodoService;
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
    public TodoIdResponse saveTodo(@RequestBody CreateTodoRequest todoDto) {
        Todo todo = new Todo();
        todo.setContent(todoDto.getContent());
        Long id = todoService.save(todo);

        return new TodoIdResponse(id);
    }

    @GetMapping("/todos")
    public FindAllTodoResponse findAllTodo() {
        List<Todo> todos = todoService.findAll();

        return new FindAllTodoResponse(todos);
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

}