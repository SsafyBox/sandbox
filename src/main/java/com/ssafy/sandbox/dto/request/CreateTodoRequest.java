package com.ssafy.sandbox.dto.request;

import lombok.*;
import org.springframework.lang.NonNull;

@ToString
@Getter @Setter
@NoArgsConstructor
public class CreateTodoRequest {
    @NonNull
    private String content;
}
