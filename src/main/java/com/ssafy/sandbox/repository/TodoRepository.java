package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.domain.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Todo todo) {
        em.persist(todo);
        return todo.getId();
    }

}
