package com.sandbox.jueun.todo.service;

import com.sandbox.jueun.todo.domain.Todo;
import com.sandbox.jueun.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getTodoList() {
       return  todoRepository.findAll();
    }

    @Transactional
    public void createTodo(String content) {
        todoRepository.save(new Todo(content));
    }

    @Transactional
    public void updateCompleted(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();

        todo.toggleCompleted();

        todoRepository.save(todo);
    }

    @Transactional
    public void deleteTodo(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();

        todoRepository.delete(todo);
    }
}
