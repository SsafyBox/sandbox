package com.sandbox.jueun.todo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String content;

    @Column(nullable = false)
    private boolean completed;

    public Todo(String content) {
        this.content = content;
        this.completed = false;
    }

    public void toggleCompleted() {
        this.completed = !completed;
    }
}
