package com.ssafy.sandbox.crud.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "todos")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Boolean completed;


    @Builder
    public TodoEntity(Long id, String content, Boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public void toggleCompleted() {
        completed = !completed;
    }

}
