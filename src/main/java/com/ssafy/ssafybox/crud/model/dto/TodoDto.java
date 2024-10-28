package com.ssafy.ssafybox.crud.model.dto;

import lombok.Getter;
import lombok.ToString;

// Todo 클래스 정의
@Getter
@ToString
public class TodoDto {

    private final Long id; // ID 필드
    private final String content; // 할 일 내용 필드
    private final boolean completed; // 완료 여부 필드

    // 생성자
    public TodoDto(Long id, String content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }
}
