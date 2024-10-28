package com.ssafy.ssafybox.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.ssafybox.model.dto.TodoDto;

public interface SsafyboxDao {

    // Create : 할 일 추가
    boolean createTodo(String content) throws SQLException;

    // Read : 할 일 조회
    List<TodoDto> readAllTodo() throws SQLException;

    // Update : 할 일 변경
    boolean updateTodo(Long todoId) throws SQLException;

    // Delete : 할 일 삭제
    boolean deleteTodo(Long todoId) throws SQLException;

    Long readTodo(String content) throws SQLException;
}
