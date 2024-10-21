package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Long save(Todo todo) {
        return todoRepository.save(todo);
    }
}
