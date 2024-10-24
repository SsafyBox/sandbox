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

    public List<Todo> findAll() {
        return em.createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }

    public Todo findOne(Long id) {
        return em.find(Todo.class, id);
    }

    public Long update(Todo todo) {
        em.merge(todo);
        return todo.getId();
    }

    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
