package com.ssafy.sandbox.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Todo {

    @Id @GeneratedValue
    private Long id;

    private String content;

    // 기본적으로 false 적용됨
    private boolean done;
}
