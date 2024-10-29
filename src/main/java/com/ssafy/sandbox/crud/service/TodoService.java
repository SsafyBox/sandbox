package com.ssafy.sandbox.crud.service;

import com.ssafy.sandbox.crud.domain.TodoEntity;
import com.ssafy.sandbox.crud.dto.request.CreateRequestDto;
import com.ssafy.sandbox.crud.dto.response.CreateResponseDto;
import com.ssafy.sandbox.crud.repository.TodoRepository;
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
        TodoEntity todoEntity = TodoEntity.builder()
                                .content(createRequestDto.getContent())
                                .completed(false).build();
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
