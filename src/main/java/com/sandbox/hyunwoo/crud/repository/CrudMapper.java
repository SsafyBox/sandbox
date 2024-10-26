package com.sandbox.hyunwoo.crud.repository;


import com.sandbox.hyunwoo.crud.dto.RequestTodo;
import com.sandbox.hyunwoo.crud.dto.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CrudMapper {

    void saveTodo(RequestTodo requestTodo);

    int updateToggle(@Param("id") Long id);

    Todo findById(@Param("id") Long id);

    List<Todo> findAll();

    int deleteTodo(@Param("id") Long id);

    List<Todo> cursorPaging(@Param("cursorId") Long cursorId, @Param("count") int count);

    List<Todo> offsetPaging(@Param("size") int size, @Param("offset") int offset);

    int getTotalCount();
}
