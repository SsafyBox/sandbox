package com.sandbox.hyunwoo.crud.service;


import com.sandbox.hyunwoo.crud.dto.RequestTodo;
import com.sandbox.hyunwoo.crud.dto.Todo;
import com.sandbox.hyunwoo.crud.repository.CrudMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "myBatis")
@RequiredArgsConstructor
public class CrudServiceMyBatisImpl implements CrudService {

    private final CrudMapper crudMapper;

    @Override
    @Transactional
    public void saveTodo(RequestTodo requestTodo) {
        crudMapper.saveTodo(requestTodo);
    }

    @Override
    @Transactional
    public int updateToggle(Long id) {
        return crudMapper.updateToggle(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Todo findById(Long id) {
        return crudMapper.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        return crudMapper.findAll();
    }

    @Override
    @Transactional
    public int deleteTodo(Long id) {
        return crudMapper.deleteTodo(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Todo> cursorPaging(Long cursorId, int count) {
        return crudMapper.cursorPaging(cursorId, count);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Todo> offsetPaging(int size, int offset) {
        return crudMapper.offsetPaging(size, offset);
    }

    @Override
    @Transactional(readOnly = true)
    public int getTotalCount() {
        return crudMapper.getTotalCount();
    }
}