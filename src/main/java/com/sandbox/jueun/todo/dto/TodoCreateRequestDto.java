package com.sandbox.jueun.todo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TodoCreateRequestDto {
    private String content;
}
