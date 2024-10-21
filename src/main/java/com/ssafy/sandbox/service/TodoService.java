package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Long save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Long update(Long id) {
        Todo todo = todoRepository.findOne(id);
        todo.setCompleted(true);

        return todoRepository.update(todo);
    }

    public void delete(Long id) {
        todoRepository.delete(id);
    }
}
