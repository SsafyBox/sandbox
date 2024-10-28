package com.ssafy.ssafybox.model.dao;

import com.ssafy.ssafybox.model.dto.TodoDto;
import org.springframework.stereotype.Repository;
import com.ssafy.ssafybox.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SsafyboxDaoImpl implements SsafyboxDao {

    public boolean createTodo(String content) throws SQLException {
        Connection c = null;
        PreparedStatement p = null;

        try {
            c = DBUtil.getConnection();
            String query = "INSERT INTO todos (content, completed) VALUES (?, false)";
            p = c.prepareStatement(query);
            p.setString(1, content);
            p.executeUpdate();
        } finally {
            DBUtil.close(p,c);
        }
        return true;
    }

    // 할 일 조회
    public List<TodoDto> readAllTodo() throws SQLException {
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        List<TodoDto> todoList = new ArrayList<>();
        try {
            c = DBUtil.getConnection();
            String query = "SELECT * FROM todos";
            p = c.prepareStatement(query);
            r = p.executeQuery(); // PreparedStatement를 통해 결과 집합을 가져옵니다.
            while (r.next()) {
                TodoDto todo = new TodoDto();
                todo.setId((long) r.getInt("id"));
                todo.setContent(r.getString("content"));
                todo.setCompleted(r.getBoolean("completed"));
                todoList.add(todo);
            }
        } finally {
            DBUtil.close(r, p, c);
        }
        return todoList;
    }

    // 할 일 완료 상태 변경
    public boolean updateTodo(Long todoId) throws SQLException {
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = DBUtil.getConnection();
            String querySelect = "SELECT completed FROM todos WHERE id = ?";
            p = c.prepareStatement(querySelect);
            p.setLong(1, todoId);
            r = p.executeQuery();
            if(r.next()) {
                boolean completed = r.getBoolean("completed");
                completed = !completed;// 토글
                c = DBUtil.getConnection();
                String query = "UPDATE todos SET completed = ? WHERE id = ?";
                p = c.prepareStatement(query);
                p.setBoolean(1, completed);
                p.setLong(2, todoId);
                p.executeUpdate();
            }
        } finally {
            DBUtil.close(r, p, c);
        }
        return true;
    }

    // 할 일 삭제
    public boolean deleteTodo(Long todoId) throws SQLException {
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = DBUtil.getConnection();
            String query = "DELETE FROM todos WHERE id = ?";
            p = c.prepareStatement(query);
            p.setLong(1, todoId);
            p.executeUpdate();
        } finally {
            DBUtil.close(p, c);
        }
        return true;
    }

    public Long readTodo(String content) throws SQLException {
        Long todoId = 0L;
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = DBUtil.getConnection();
            String query = "SELECT id FROM todos WHERE content = ?";
            p = c.prepareStatement(query);
            p.setString(1, content);
            r = p.executeQuery();
            if(r.next()) {
                todoId = r.getLong("id");
            }
        } finally {
            DBUtil.close(p, c);
        }
        return todoId;
    }

}