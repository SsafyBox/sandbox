package com.ssafy.ssafybox.model.service;

import com.ssafy.ssafybox.model.dto.TodoDto;

import java.sql.SQLException;
import java.util.List;

public interface SsafyboxService {
    boolean createTodo(String content) throws SQLException;
    List<TodoDto> readAllTodo() throws SQLException;
    boolean deleteTodo(Long id) throws SQLException;
    boolean updateTodo(Long id) throws SQLException;
    Long readTodo(String content) throws SQLException;
}
