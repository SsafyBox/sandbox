package com.ssafy.ssafybox.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Todo 클래스 정의
@Setter
@Getter
@ToString
public class TodoDto {

    // Getter와 Setter 메소드
    private Long id; // ID 필드
    private String content; // 할 일 내용 필드
    private boolean completed; // 완료 여부 필드

    public TodoDto(){}

    // 생성자
    public TodoDto(Long id, String content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public Boolean getCompleted() {
        return completed;
    }

}
