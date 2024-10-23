package com.sandbox.jueun.todo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoCreateRequestDto {
    @NotNull
    private String content;
}
