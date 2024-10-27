package com.ssafy.sandbox.crud.service;

import com.ssafy.sandbox.crud.domain.Todo;
import com.ssafy.sandbox.crud.dto.response.FindAllTodoResponse;
import com.ssafy.sandbox.crud.dto.response.TodoIdResponse;
import com.ssafy.sandbox.crud.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoIdResponse save(Todo todo) {
        return new TodoIdResponse(todoRepository.save(todo));
    }

    @Transactional(readOnly = true)
    public FindAllTodoResponse findAll() {
        return new FindAllTodoResponse(todoRepository.findAll());
    }

    public TodoIdResponse update(Long id) {
        Todo todo = todoRepository.findOne(id);
        todo.setCompleted(!todo.isCompleted());

        return new TodoIdResponse(todoRepository.update(todo));
    }

    public void delete(Long id) {
        todoRepository.delete(id);
    }
}
