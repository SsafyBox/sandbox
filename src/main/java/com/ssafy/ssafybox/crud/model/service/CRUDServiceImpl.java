package com.ssafy.ssafybox.crud.model.service;

import com.ssafy.ssafybox.crud.model.dto.TodoDto;
import com.ssafy.ssafybox.crud.model.mapper.CRUDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDServiceImpl implements CRUDService {

    private final CRUDMapper CRUDMapper;

    @Autowired
    public CRUDServiceImpl(CRUDMapper CRUDMapper) {
        this.CRUDMapper = CRUDMapper;
    }

    @Override
    public boolean createTodo(String content) {
        try {
            CRUDMapper.createTodo(content);
            return true; // 성공적으로 추가됨
        } catch (Exception e) {
            return false; // 예외 발생, 실패
        }
    }

    @Override
    public List<TodoDto> readAllTodo() {
        return CRUDMapper.readAllTodo();
    }

    @Override
    public boolean updateTodo(Long todoId) {
        try {
            CRUDMapper.updateTodo(todoId);
            return true; // 성공적으로 추가됨
        } catch (Exception e) {
            return false; // 예외 발생, 실패
        }
    }

    @Override
    public boolean deleteTodo(Long todoId) {
        try {
            CRUDMapper.deleteTodo(todoId);
            return true; // 성공적으로 추가됨
        } catch (Exception e) {
            return false; // 예외 발생, 실패
        }
    }

    @Override
    public Long recentTodoId() {
        return CRUDMapper.recentTodoId();
    }
}
