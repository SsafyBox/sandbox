package com.ssafy.ssafybox.crud.model.service;

import com.ssafy.ssafybox.crud.model.dto.TodoDto;

import java.util.List;

public interface CRUDService {
    boolean createTodo(String content);
    List<TodoDto> readAllTodo();
    boolean updateTodo(Long todoId);
    boolean deleteTodo(Long todoId);
    Long recentTodoId();
}
