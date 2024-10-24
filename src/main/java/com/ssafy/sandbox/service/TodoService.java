package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.TodoEntity;
import com.ssafy.sandbox.dto.request.CreateRequestDto;
import com.ssafy.sandbox.dto.response.CreateResponseDto;
import com.ssafy.sandbox.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public CreateResponseDto create(CreateRequestDto createRequestDto) {
        TodoEntity todoEntity =  new TodoEntity();
        todoEntity.setContent(createRequestDto.getContent());
        return todoRepository.save(todoEntity);
    }

    public List<TodoEntity> read() {
        return todoRepository.findAll();
    }

    public void update(Long id) {
        todoRepository.update(id);
    }

    public void delete(Long id) {
        todoRepository.delete(id);
    }

}
