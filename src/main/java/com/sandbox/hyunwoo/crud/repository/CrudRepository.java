package com.sandbox.hyunwoo.crud.repository;



import com.sandbox.hyunwoo.crud.dto.RequestTodo;
import com.sandbox.hyunwoo.crud.dto.Todo;

import java.util.List;

public interface CrudRepository {

    void saveTodo(RequestTodo requestTodo);

    int updateToggle(Long id);

    Todo findById(Long id);

    List<Todo> findAll();

    int deleteTodo(Long id);

    List<Todo> cursorPaging(Long cursorId, int count);

    List<Todo> offsetPaging(int size, int offset);

    int getTotalCount();
}
