package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.domain.TodoEntity;
import com.ssafy.sandbox.dto.response.CreateResponseDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    public CreateResponseDto save(TodoEntity todoEntity) {
        em.persist(todoEntity);
        CreateResponseDto createResponseDto = new CreateResponseDto();
        createResponseDto.setId(todoEntity.getId());
        createResponseDto.setCompleted(todoEntity.getCompleted());
        return createResponseDto;
    }

    public List<TodoEntity> findAll() {
        return em.createQuery("select t from TodoEntity t", TodoEntity.class).getResultList();
    }

    public void update(Long id) {
        TodoEntity entity = em.find(TodoEntity.class, id);
        if (entity != null) {
            entity.setCompleted(!entity.getCompleted());
            em.persist(entity);
        }
    }

    public void delete(Long id) {
        TodoEntity entity = em.find(TodoEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

}
