package com.ssafy.ssafybox.crud.model.mapper;

import com.ssafy.ssafybox.crud.model.dto.TodoDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CRUDMapper {

    @Insert("INSERT INTO todos (content, completed) VALUES (#{content}, false)")
    void createTodo(String content);

    @Select("SELECT * FROM todos")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "content", property = "content"),
            @Result(column = "completed", property = "completed")
    })
    List<TodoDto> readAllTodo();

    @Update("UPDATE todos SET completed = NOT completed WHERE id = #{todoId}")
    void updateTodo(Long todoId);

    @Delete("DELETE FROM todos WHERE id = #{todoId}")
    void deleteTodo(Long todoId);

    @Select("SELECT MAX(id) FROM todos")
    Long recentTodoId();
}